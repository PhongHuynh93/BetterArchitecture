package com.bend.components

import com.bend.components.apis.ApiManager
import com.bend.components.services.PreferenceService
import com.bend.shared.entities.Team


/**
 *
 * FootballApp
 * SelectFavoriteTeamsComponent
 *
 * Created on 12/07/2017
 * Copyright (c) 2017 SHAPE A/S. All rights reserved.
 *
 */
class SelectFavoriteTeamsComponent {

    fun getTeams() = ApiManager.teamApi.getTeams()

    fun getFavoriteTeams() = PreferenceService.retrieveFavoriteTeams()

    fun saveFavoriteTeams(teams: List<Team>) = PreferenceService.saveFavoriteTeams(teams)
}