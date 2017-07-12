package com.bend.footballapp.viewmodels

import com.bend.components.MainComponent
import com.bend.footballapp.BR
import com.bend.footballapp.R
import com.bend.footballapp.ui.SmartBindingRecyclerViewAdapter
import com.bend.footballapp.viewmodels.items.TeamItemViewModel
import com.bend.shared.entities.Team
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
class MainViewModel(val mainComponent: MainComponent) : BaseViewModel() {

    val itemBinding = ItemBinding.of<TeamItemViewModel>(BR.viewModel, R.layout.item_team)
    val adapter = SmartBindingRecyclerViewAdapter<TeamItemViewModel>()

    override val bindingLayoutRes = R.layout.view_main

    override fun onStart() {
        super.onStart()

        showLoading()
        fetchTeams()
    }

    private fun fetchTeams() {

        showContent()
        handleDisposal(mainComponent.getTeams()
                .subscribe({
                   setContent(it)
                }, {
                    handleError(it)
                }))
    }

    private fun setContent(teams: List<Team>) {
        adapter.setItems(teams.map { TeamItemViewModel(it) })
        showContent()
    }
}