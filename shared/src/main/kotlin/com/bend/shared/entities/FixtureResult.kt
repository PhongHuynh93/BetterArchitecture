package com.bend.shared.entities

import com.google.gson.annotations.SerializedName


/**
 *
 * FootballApp
 * FixtureResult
 *
 * Created on 13/07/2017
 * Copyright (c) 2017 SHAPE A/S. All rights reserved.
 *
 */
data class FixtureResult(

        @SerializedName("scoreHome")
        val scoreHome: Int = 0,

        @SerializedName("scoreAway")
        val scoreAway: Int = 0,

        @SerializedName("finished")
        val finished: Boolean = true
)