package com.bend.components.entities

import com.bend.shared.entities.Fixture
import com.bend.shared.entities.Team


/**
 *
 * FootballApp
 * FixtureAndTeam
 *
 * Created on 13/07/2017
 * Copyright (c) 2017 SHAPE A/S. All rights reserved.
 *
 */
data class FixtureWithTeams(

        val fixture: Fixture,

        val homeTeam: Team,

        val awayTeam: Team
)