package com.bend.footballapp.viewmodels

import com.bend.components.MainComponent
import com.bend.footballapp.BR
import com.bend.footballapp.R
import com.bend.footballapp.ui.SmartBindingRecyclerViewAdapter
import com.bend.footballapp.viewmodels.items.TeamItemViewModel
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

    val itemBinding = ItemBinding.of<TeamItemViewModel>(BR.viewModel, R.layout.item_team)
    val adapter = SmartBindingRecyclerViewAdapter<TeamItemViewModel>()

    override val bindingLayoutRes = R.layout.view_main

    override fun onStart() {
        super.onStart()

        if (!component.userHasFavoriteTeams()) {
            listener.openSelectFavoriteTeamsScreen()
        }

        showLoading()
        //fetchTeams()
    }

    /*private fun fetchTeams() {
        handleDisposal(selectFavoriteTeamsComponent.getTeams()
                .subscribe({
                    setContent(it)
                }, {
                    handleError(it)
                }))
    }

    private fun setContent(teams: List<Team>) {
        adapter.setItems(teams.map { TeamItemViewModel(it, selectFavoriteTeamsComponent.getFavoriteTeams().contains(it)) })
        showContent()
    }

    fun onSaveClicked(view: View) {
        Toast.makeText(CustomApplication.get(), "Saved teams!!", Toast.LENGTH_SHORT).show()
        selectFavoriteTeamsComponent.saveFavoriteTeams(adapter.getItems()?.filter { it.isSelected() }?.map { it.team } ?: emptyList())
    }*/
}