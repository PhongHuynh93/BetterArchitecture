package com.bend.shared.entities

import com.google.gson.annotations.SerializedName
import org.joda.time.DateTime


/**
 *
 * FootballApp
 * Fixture
 *
 * Created on 13/07/2017
 *
 */
data class Fixture (

        @SerializedName("fixtureId")
        val fixtureId: Int = 0,

        @SerializedName("teamIdHome")
        val teamIdHome: Int = 0,

        @SerializedName("teamIdAway")
        val teamIdAway: Int = 0,

        @SerializedName("startTime")
        val startTime: DateTime? = null,

        @SerializedName("result")
        val result: FixtureResult? = null
)