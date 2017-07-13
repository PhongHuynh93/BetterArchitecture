package com.bend.shared.entities

import com.google.gson.annotations.SerializedName


/**
 *
 * FootballApp
 * Fixture
 *
 * Created on 13/07/2017
 * Copyright (c) 2017 SHAPE A/S. All rights reserved.
 *
 */
data class Fixture (

        @SerializedName("fixtureId")
        val fixtureId: Int = 0
)