package com.bend.shared.responses

import com.bend.shared.entities.Team
import com.google.gson.annotations.SerializedName


/**
 *
 * FootballApp
 * TeamsResponse
 *
 * Created on 12/07/2017
 *
 */
class TeamsResponse (

        @SerializedName("teams")
        var teams: MutableList<Team> = mutableListOf()
)