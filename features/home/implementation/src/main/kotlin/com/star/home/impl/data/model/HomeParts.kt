package com.star.home.impl.data.model

enum class HomeParts(val part: String) {
    MINUTELY("minutely"),
    HOURLY("hourly"),
    DAILY("daily"),
    ALERTS("alerts"),
    CURRENT("current");

    companion object {
        fun parse(part: String): HomeParts =
            values().find { it.part == part } ?: CURRENT
    }
}
