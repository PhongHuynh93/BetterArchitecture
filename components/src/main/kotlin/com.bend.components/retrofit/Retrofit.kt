package com.bend.components.retrofit

import com.bend.components.serializers.DateTimeSerializer
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.OkHttpClient
import org.joda.time.DateTime
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


/**
 *
 * FootballApp
 * Retrofit
 *
 * Created on 12/07/2017
 *
 */
object Retrofit {

    private var _apiService: ApiService? = null

    private var _infoProvider: ApiInfoProvider? = null

    fun initialize(infoProvider: ApiInfoProvider) {
        _infoProvider = infoProvider
    }

    val apiService: ApiService
        get() {

            if (_apiService == null) {
                synchronized(Retrofit::class.java) {
                    val client = OkHttpClient.Builder()
                            .connectTimeout(30, TimeUnit.SECONDS)
                            .readTimeout(30, TimeUnit.SECONDS)
                            .build()

                    val retrofit = retrofit2.Retrofit.Builder()
                            .baseUrl(_infoProvider!!.getBaseUrl())
                            .client(client)
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                            .addConverterFactory(GsonConverterFactory.create(GsonService.gson))
                            .build()

                    _apiService = retrofit.create(ApiService::class.java)
                }
            }

            return _apiService!!
        }
}
