package com.bend.components

import com.bend.components.services.PreferenceService


/**
 *
 * FootballApp
 * MainComponent
 *
 * Created on 13/07/2017
 * Copyright (c) 2017 SHAPE A/S. All rights reserved.
 *
 */
class MainComponent {

    fun userHasFavoriteTeams() = PreferenceService.retrieveFavoriteTeams().isNotEmpty()
}