package com.star.home.impl.domain.model

enum class Period(val description: String) {
    TODAY("Today"),
    TOMORROW("Tomorrow"),
    NEXT_10_DAY("Next 10 Days");

    companion object {
        fun Period.parse(description: String): Period = values().find {
            it.description == description.lowercase()
        } ?: TODAY
    }
}