package com.bend.components.extensions

import android.content.SharedPreferences


/**
 *
 * FootballApp
 * extensions
 *
 * Created on 13/07/2017
 *
 */

// Shared preferences
fun SharedPreferences.put(key: String, value: Any) {
    val editor = this.edit()

    if (value is Boolean) editor.putBoolean(key, value)
    else if (value is String) editor.putString(key, value)
    else if (value is Float) editor.putFloat(key, value)
    else if (value is Int) editor.putInt(key, value)
    else if (value is Long) editor.putLong(key, value)
    else throw UnsupportedOperationException()

    editor.apply()
}
