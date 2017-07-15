package com.bend.components.retrofit

import com.bend.components.serializers.DateTimeSerializer
import com.google.gson.GsonBuilder
import org.joda.time.DateTime


/**
 *
 * FootballApp
 * GsonService
 *
 * Created on 13/07/2017
 *
 */
object GsonService {

    val gson = GsonBuilder().registerTypeAdapter(DateTime::class.java, DateTimeSerializer()).create()
}