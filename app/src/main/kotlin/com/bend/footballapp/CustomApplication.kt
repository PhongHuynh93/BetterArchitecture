package com.bend.footballapp

import android.app.Application
import android.content.Context


/**
 *
 * FootballApp
 * CustomApplication
 *
 * Created on 12/07/2017
 * Copyright (c) 2017 SHAPE A/S. All rights reserved.
 *
 */
class CustomApplication : Application() {

    companion object {

        private var _context: Context? = null

        @JvmStatic
        fun get(): Context {
            return _context!!
        }
    }

    override fun onCreate() {
        super.onCreate()

        _context = this
    }
}