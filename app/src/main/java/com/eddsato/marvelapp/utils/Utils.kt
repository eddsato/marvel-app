package com.eddsato.marvelapp.utils

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


object Utils {

    const val SIMPLE_DATE_FORMAT_ISO_8601 = "yyyy-MM-dd'T'HH:mm:ss'Z'"
    val BR_LOCALE = Locale("pt", "BR")

    fun formatDate(formatType: String, date: Date): String {
        val dateFormatterInstance = SimpleDateFormat(formatType, BR_LOCALE)

        return dateFormatterInstance.format(date)
    }
}