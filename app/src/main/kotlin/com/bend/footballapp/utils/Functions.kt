package com.bend.footballapp.utils

import android.content.Context
import android.content.SharedPreferences
import android.support.annotation.ColorRes
import android.support.annotation.DimenRes
import android.support.annotation.DrawableRes
import android.support.annotation.StringRes
import android.support.v4.content.ContextCompat
import com.bend.footballapp.CustomApplication


/**
 *
 * FootballApp
 * Functions
 *
 * Created on 13/07/2017
 *
 */

fun getString(@StringRes resId: Int): String = CustomApplication.get().getString(resId)!!

fun getString(@StringRes resId: Int, vararg formatArgs: Any): String = CustomApplication.get().resources.getString(resId, *formatArgs)

fun getColor(@ColorRes resId: Int) = ContextCompat.getColor(CustomApplication.get(), resId)

fun getDimension(@DimenRes resId: Int) = CustomApplication.get().resources.getDimension(resId)

fun getDrawable(@DrawableRes resId: Int) = ContextCompat.getDrawable(CustomApplication.get(), resId)!!

fun getPreferences(name : String): SharedPreferences = CustomApplication.get().getSharedPreferences(name, Context.MODE_PRIVATE)