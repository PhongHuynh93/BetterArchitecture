package com.bend.footballapp.viewmodels

import android.view.View
import android.widget.Toast
import com.bend.components.SelectFavoriteTeamsComponent
import com.bend.footballapp.BR
import com.bend.footballapp.CustomApplication
import com.bend.footballapp.R
import com.bend.footballapp.ui.SmartBindingRecyclerViewAdapter
import com.bend.footballapp.viewmodels.items.TeamItemViewModel
import com.bend.shared.entities.Team
import me.tatarka.bindingcollectionadapter2.ItemBinding


/**
 *
 * FootballApp
 * SelectFavoriteTeamsViewModel
 *
 * Created on 13/07/2017
 * Copyright (c) 2017 SHAPE A/S. All rights reserved.
 *
 */
class SelectFavoriteTeamsViewModel(val component: SelectFavoriteTeamsComponent) : BaseViewModel() {

    val itemBinding = ItemBinding.of<TeamItemViewModel>(BR.viewModel, R.layout.item_team)
    val adapter = SmartBindingRecyclerViewAdapter<TeamItemViewModel>()

    override val bindingLayoutRes = R.layout.view_select_favorite_teams

    override fun onStart() {
        super.onStart()

        showLoading()
        fetchTeams()
    }

    private fun fetchTeams() {
        handleDisposal(component.getTeams()
                .subscribe({
                    setContent(it)
                }, {
                    handleError(it)
                }))
    }

    private fun setContent(teams: List<Team>) {
        adapter.setItems(teams.map { TeamItemViewModel(it, component.getFavoriteTeams().contains(it)) })
        showContent()
    }

    fun onSaveClicked(view: View) {
        Toast.makeText(CustomApplication.get(), "Saved teams!!", Toast.LENGTH_SHORT).show()
        component.saveFavoriteTeams(adapter.getItems()?.filter { it.isSelected() }?.map { it.team } ?: emptyList())
    }
}