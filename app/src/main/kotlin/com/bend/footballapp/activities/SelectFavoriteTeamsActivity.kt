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
 *
 */
class SelectFavoriteTeamsActivity : BaseActivity(), SelectFavoriteTeamsViewModel.Listener {

    override fun handleIntent(intent: Intent) {}

    override val viewModel = SelectFavoriteTeamsViewModel(SelectFavoriteTeamsComponent(), this)

    override fun navigateUp() {
        finishActivity()
    }

    override fun finishActivity() {
        finishActivityWithAnimation(OUT_BOTTOM)
    }

    companion object {

        fun getIntent(context: Context) = Intent(context, SelectFavoriteTeamsActivity::class.java)
    }
}