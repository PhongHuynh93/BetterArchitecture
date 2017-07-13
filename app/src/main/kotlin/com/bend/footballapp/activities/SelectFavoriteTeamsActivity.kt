package com.bend.footballapp.activities

import android.content.Context
import android.content.Intent
import com.bend.components.SelectFavoriteTeamsComponent
import com.bend.footballapp.viewmodels.SelectFavoriteTeamsViewModel


/**
 *
 * FootballApp
 * SelectFavoriteTeamsActivity
 *
 * Created on 13/07/2017
 * Copyright (c) 2017 SHAPE A/S. All rights reserved.
 *
 */
class SelectFavoriteTeamsActivity : BaseActivity() {

    override fun handleIntent(intent: Intent) {}

    override val viewModel = SelectFavoriteTeamsViewModel(SelectFavoriteTeamsComponent())

    companion object {

        fun getIntent(context: Context) = Intent(context, SelectFavoriteTeamsActivity::class.java)
    }
}