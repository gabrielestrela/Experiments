package com.star.coreandroid.storage.preferences

import android.content.Context
import android.content.SharedPreferences

interface Preferences {
    fun <T>getValue(key: String, default: T): Any?
    fun <T>setValue(key: String, value: T)
}

class AppPreferences(
    private val context: Context
): Preferences {

    val systemPreferences: SharedPreferences by lazy {
        context.getSharedPreferences(name, Context.MODE_PRIVATE)
    }

    val editor: SharedPreferences.Editor by lazy {
        systemPreferences.edit()
    }

    override fun <T> getValue(key: String, default: T): Any? {
        with(systemPreferences) {
            return when (default) {
                is Boolean -> getBoolean(key, default)
                is String -> getString(key, default).orEmpty()
                is Float -> getFloat(key, default)
                is Long -> getLong(key, default)
                is Int -> getInt(key, default)
                else -> null
            }
        }
    }

    override fun <T> setValue(key: String, value: T) {
        when (value) {
            is Boolean -> editor.putBoolean(key, value)
            is String -> editor.putString(key, value)
            is Float -> editor.putFloat(key, value)
            is Long -> editor.putLong(key, value)
            is Int -> editor.putInt(key, value)
            else -> { /* Do Nothing */ }
        }
        editor.apply()
    }

    companion object {
        const val name: String = "App_Preferences"
    }
}
