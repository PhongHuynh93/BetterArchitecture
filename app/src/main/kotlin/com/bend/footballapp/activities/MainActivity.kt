package com.bend.footballapp.activities

import android.content.Intent
import com.bend.components.MainComponent
import com.bend.footballapp.viewmodels.MainViewModel


/**
 *
 * FootballApp
 * MainActivity
 *
 * Created on 12/07/2017
 * Copyright (c) 2017 SHAPE A/S. All rights reserved.
 *
 */
class MainActivity : BaseActivity(), MainViewModel.Listener {

    override val viewModel = MainViewModel(MainComponent(), this)

    override fun handleIntent(intent: Intent) {}

    override fun openSelectFavoriteTeamsScreen() {
        launchActivity(SelectFavoriteTeamsActivity.getIntent(this), IN_FROM_BOTTOM)
    }
}
