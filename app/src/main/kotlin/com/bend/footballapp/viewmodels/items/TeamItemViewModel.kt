package com.bend.footballapp.viewmodels.items

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
class TeamItemViewModel(val team: Team) : ItemDiffUtil.ComparableItem {

    val teamName = team.teamName

    override fun areItemsTheSame(otherItem: Any) = otherItem is TeamItemViewModel && otherItem.team.teamId == team.teamId

    override fun areContentsUnChanged(otherItem: Any) = otherItem is TeamItemViewModel && otherItem.team == team
}