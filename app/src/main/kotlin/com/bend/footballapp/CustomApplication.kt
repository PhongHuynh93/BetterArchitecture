package com.bend.footballapp

import android.app.Application
import android.content.Context
import com.bend.components.retrofit.ApiInfoProvider
import com.bend.components.retrofit.Retrofit
import com.bend.components.services.NotificationService
import com.bend.components.services.PreferenceService


/**
 *
 * FootballApp
 * CustomApplication
 *
 * Created on 12/07/2017
 *
 */
class CustomApplication : Application(), ApiInfoProvider {

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

        NotificationService.initialise(this)
        PreferenceService.initialise(this)
        Retrofit.initialize(this)
    }

    override fun getBaseUrl() = "http://www.footballapp.com/api/"
}