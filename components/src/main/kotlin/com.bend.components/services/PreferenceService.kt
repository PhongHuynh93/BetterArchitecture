package com.bend.components.services

import android.content.Context
import android.content.SharedPreferences
import com.bend.components.extensions.put
import com.bend.components.retrofit.GsonService
import com.bend.shared.entities.Team
import com.google.gson.reflect.TypeToken




/**
 *
 * FootballApp
 * PreferenceService
 *
 * Created on 13/07/2017
 * Copyright (c) 2017 SHAPE A/S. All rights reserved.
 *
 */
object PreferenceService {

    private val PREFS_NAME = "football_app_refs"

    private val KEY_FAVORITE_TEAMS = "key_favorite_teams"

    private lateinit var _prefs: SharedPreferences

    fun initialize(context: Context) {
        _prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)!!
    }

    fun saveFavoriteTeams(teams: List<Team>) {
        _prefs.put(KEY_FAVORITE_TEAMS, GsonService.gson.toJson(teams))
    }

    fun retrieveFavoriteTeams(): List<Team> {
        return GsonService.gson.fromJson(_prefs.getString(KEY_FAVORITE_TEAMS, ""), object : TypeToken<List<Team>>() {}.type) ?: emptyList()
    }
}