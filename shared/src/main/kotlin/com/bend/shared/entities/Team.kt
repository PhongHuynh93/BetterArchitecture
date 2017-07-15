package com.bend.shared.entities

import com.google.gson.annotations.SerializedName


/**
 *
 * FootballApp
 * Team
 *
 * Created on 12/07/2017
 *
 */
data class Team (

        @SerializedName("teamId")
        var teamId: Int = 0,

        @SerializedName("teamName")
        var teamName: String? = null,

        @SerializedName("bannerUrl")
        var bannerUrl: String? = null
)