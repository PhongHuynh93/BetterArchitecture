package com.bend.footballapp.viewmodels.items

import android.databinding.ObservableBoolean
import android.view.View
import com.bend.footballapp.ui.ItemDiffUtil
import com.bend.shared.entities.Team


/**
 *
 * FootballApp
 * TeamItemViewModel
 *
 * Created on 12/07/2017
 * Copyright (c) 2017 SHAPE A/S. All rights reserved.
 *
 */
class TeamItemViewModel(val team: Team, isSelected: Boolean = false) : ItemDiffUtil.ComparableItem {

    val teamName = team.teamName
    val bannerUrl = team.bannerUrl

    val showSelected = ObservableBoolean(isSelected)

    fun isSelected() = showSelected.get()

    @Suppress("UNUSED_PARAMETER")
    fun onItemClicked(view: View) {

        // Flip the state
        showSelected.set(!showSelected.get())
    }

    override fun areItemsTheSame(otherItem: Any) = otherItem is TeamItemViewModel && otherItem.team.teamId == team.teamId

    override fun areContentsUnChanged(otherItem: Any) = otherItem is TeamItemViewModel && otherItem.team == team
}