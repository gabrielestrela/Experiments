package com.star.corekotlin.date

import com.star.corekotlin.primitives.string.extension.empty
import java.text.SimpleDateFormat
import java.util.Locale

fun Long?.fromMillisToFormatted(
    datePattern: DatePattern = DatePattern.DAY_IN_MONTH_MONTH_WEEKDAY,
    locale: Locale = Locale("pt", "BR")
): String {
    if (this == null) String.empty()
    val sdf = SimpleDateFormat(datePattern.pattern, locale)
    return sdf.format(this)
}
