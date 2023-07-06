package com.star.coreandroid.provider.location

import android.Manifest
import android.content.Context
import android.os.Looper
import androidx.annotation.RequiresPermission
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.Priority
import com.google.android.gms.tasks.CancellationToken
import com.google.android.gms.tasks.CancellationTokenSource
import com.google.android.gms.tasks.OnTokenCanceledListener
import com.star.coreandroid.provider.resource.ResourceProvider
import com.star.corekotlin.primitives.doubles.extension.orZero
import com.star.corekotlin.provider.dispatcher.DispatcherProvider
import com.star.experiments.coreandroid.R
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flowOn

class LocationProvider(
    private val context: Context,
    private val resourceProvider: ResourceProvider,
    private val dispatcher: DispatcherProvider
) {
    private var pollDelay = 5000L

    private val fusedLocationClient by lazy {
        LocationServices.getFusedLocationProviderClient(context)
    }

    private val locationRequest by lazy {
        LocationRequest.Builder(pollDelay).build()
    }

    private val cancellationToken by lazy {
        object : CancellationToken() {
            override fun onCanceledRequested(p0: OnTokenCanceledListener): CancellationToken =
                CancellationTokenSource().token

            override fun isCancellationRequested(): Boolean = false
        }
    }

    @ExperimentalCoroutinesApi
    @RequiresPermission(anyOf = [Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION])
    fun currentLocationFlow(): Flow<LocationState> = callbackFlow {
        trySend(LocationState.Loading)
        fusedLocationClient.getCurrentLocation(
            Priority.PRIORITY_BALANCED_POWER_ACCURACY,
            cancellationToken
        ).addOnSuccessListener { location ->
            location?.let { safeLocation ->
                trySend(LocationState.Success(safeLocation.latitude, safeLocation.longitude))
            } ?: trySend(
                LocationState.Error(resourceProvider.string(R.string.location_success_but_null))
            )
        }.addOnFailureListener { exception ->
            val report = resourceProvider.string(
                R.string.location_failure_report,
                exception.message.orEmpty()
            )
            trySend(LocationState.Error(report))
            close()
        }.addOnCanceledListener {
            trySend(
                LocationState.Error(resourceProvider.string(R.string.location_failure_cancelled))
            )
        }

        awaitClose {  }
    }.flowOn(dispatcher.io())

    @ExperimentalCoroutinesApi
    @RequiresPermission(anyOf = [Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION])
    fun locationUpdateFlow(): Flow<LocationState> = callbackFlow<LocationState> {
        val callback = object : LocationCallback() {
            override fun onLocationResult(result: LocationResult) {
                trySend(
                    LocationState.Success(
                        result.lastLocation?.latitude.orZero(),
                        result.lastLocation?.longitude.orZero()
                    )
                )
            }
        }

        fusedLocationClient.requestLocationUpdates(
            locationRequest,
            callback,
            Looper.getMainLooper()
        ).addOnFailureListener { exception ->
            trySend(
                LocationState.Error(
                    resourceProvider.string(
                        R.string.location_failure_report,
                        exception.message.orEmpty()
                    )
                )
            )
            close(exception)
        }

        awaitClose {
            fusedLocationClient.removeLocationUpdates(callback)
        }
    }.flowOn(dispatcher.io())

    fun changePollTime(newDelay: Long) { pollDelay = newDelay }
}
