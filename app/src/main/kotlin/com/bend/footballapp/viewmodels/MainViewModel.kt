package com.bend.footballapp.viewmodels

import com.bend.components.MainComponent
import com.bend.footballapp.BR
import com.bend.footballapp.R
import com.bend.footballapp.ui.SmartBindingRecyclerViewAdapter
import com.bend.footballapp.viewmodels.items.FixtureItemViewModel
import com.bend.shared.entities.Fixture
import me.tatarka.bindingcollectionadapter2.ItemBinding


/**
 *
 * FootballApp
 * MainViewModel
 *
 * Created on 12/07/2017
 * Copyright (c) 2017 SHAPE A/S. All rights reserved.
 *
 */
class MainViewModel(val component: MainComponent, val listener: Listener) : BaseViewModel() {

    interface Listener {
        fun openSelectFavoriteTeamsScreen()
    }

    val itemBinding = ItemBinding.of<FixtureItemViewModel>(BR.viewModel, R.layout.item_fixture)
    val adapter = SmartBindingRecyclerViewAdapter<FixtureItemViewModel>()

    override val bindingLayoutRes = R.layout.view_main

    override fun onStart() {
        super.onStart()

        if (!component.userHasFavoriteTeams()) {
            listener.openSelectFavoriteTeamsScreen()
        }

        showLoading()
        fetchFixtures()
    }

    private fun fetchFixtures() {
        handleDisposal(component.getFixtures()
                .subscribe({
                    setContent(it)
                }, {
                    handleError(it)
                }))
    }

    private fun setContent(teams: List<Fixture>) {
        adapter.setItems(teams.map { FixtureItemViewModel(it) })
        showContent()
    }
}