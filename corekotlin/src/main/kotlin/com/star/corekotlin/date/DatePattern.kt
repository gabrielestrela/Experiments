package com.star.corekotlin.date

enum class DatePattern(val id: String, val pattern: String) {
    DAY_IN_MONTH_MONTH_WEEKDAY("HomeFormat", "dd MMMMM, EEEEE"),
    HOUR_AM_PM("ForecastHourly", "hh a");

    companion object {
        fun parse(id: String): DatePattern = values().find {
            it.id == id
        } ?: DAY_IN_MONTH_MONTH_WEEKDAY
    }
}
