package com.star.home.impl.data.api

import com.star.home.impl.data.model.HomeParts
import com.star.home.impl.data.model.response.HomeResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface HomeApi {
    @GET("")
    fun getHomeData(
        @Query(LAT) lat: String,
        @Query(LON) lon: String,
        @Query(EXCLUDES) excludes: String = getExcludes(),
    ): HomeResponse

    private fun getExcludes(): String =
        mutableListOf(
            HomeParts.MINUTELY.part,
            HomeParts.HOURLY.part,
            HomeParts.DAILY.part,
            HomeParts.ALERTS.part
        ).joinToString(SEPARATOR)

    companion object {
        private const val LAT = "lat"
        private const val LON = "lon"
        private const val EXCLUDES = "exclude"
        private const val SEPARATOR = ","
    }
}
