package com.star.coreandroid.provider.location

sealed class LocationState {
    object Loading : LocationState()
    data class Error(val message: String) : LocationState()
    data class Success(
        val lat: Double = 0.0,
        val lon: Double = 0.0
    ) : LocationState()

    fun LocationState.fold(
        onError: () -> Unit,
        onLoading: () -> Unit,
        onSuccess: (lat: Double, lon: Double) -> Unit
    ) {
        when (this) {
            is Error -> onError.invoke()
            is Success -> onSuccess.invoke(this.lat, this.lon)
            else -> onLoading.invoke()
        }
    }
}