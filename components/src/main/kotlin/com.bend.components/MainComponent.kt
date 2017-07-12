package com.bend.components

import com.bend.components.apis.ApiManager


/**
 *
 * FootballApp
 * MainComponent
 *
 * Created on 12/07/2017
 * Copyright (c) 2017 SHAPE A/S. All rights reserved.
 *
 */
class MainComponent {

    fun getTeams() = ApiManager.teamApi.getTeams()
}