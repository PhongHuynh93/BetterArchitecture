package com.bend.footballapp.viewmodels.items

import com.bend.footballapp.ui.ItemDiffUtil
import com.bend.shared.entities.Fixture


/**
 *
 * FootballApp
 * FixtureItemViewModel
 *
 * Created on 13/07/2017
 * Copyright (c) 2017 SHAPE A/S. All rights reserved.
 *
 */
class FixtureItemViewModel(val fixture: Fixture) : ItemDiffUtil.ComparableItem {

    override fun areItemsTheSame(otherItem: Any) = otherItem is FixtureItemViewModel && otherItem.fixture.fixtureId == fixture.fixtureId

    override fun areContentsUnChanged(otherItem: Any) = otherItem is FixtureItemViewModel && otherItem.fixture == fixture
}