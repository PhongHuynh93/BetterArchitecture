package com.bend.components.apis

import com.bend.components.retrofit.Retrofit


/**
 *
 * FootballApp
 * TeamApi
 *
 * Created on 12/07/2017
 *
 */
class TeamApi: BaseApi() {

    fun getTeams() = runAsync(Retrofit.apiService.getTeams()).map { it.teams }
}