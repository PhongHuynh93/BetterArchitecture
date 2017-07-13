package com.bend.shared.responses

import com.bend.shared.entities.Fixture
import com.google.gson.annotations.SerializedName


/**
 *
 * FootballApp
 * FixturesResponse
 *
 * Created on 13/07/2017
 * Copyright (c) 2017 SHAPE A/S. All rights reserved.
 *
 */
data class FixturesResponse (

        @SerializedName("fixtures")
        val fixtures: List<Fixture>
)