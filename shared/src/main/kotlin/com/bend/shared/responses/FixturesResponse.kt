package com.bend.shared.responses

import com.bend.shared.entities.Fixture
import com.google.gson.annotations.SerializedName


/**
 *
 * FootballApp
 * FixturesResponse
 *
 * Created on 13/07/2017
 *
 */
data class FixturesResponse (

        @SerializedName("fixtures")
        val fixtures: List<Fixture>
)