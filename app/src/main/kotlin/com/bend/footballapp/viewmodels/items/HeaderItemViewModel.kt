package com.bend.footballapp.viewmodels.items

import com.bend.footballapp.ui.ItemDiffUtil


/**
 *
 * FootballApp
 * HeaderItemViewModel
 *
 * Created on 13/07/2017
 * Copyright (c) 2017 SHAPE A/S. All rights reserved.
 *
 */
class HeaderItemViewModel(val text: String) : ItemDiffUtil.ComparableItem {

    override fun areItemsTheSame(otherItem: Any) = otherItem is HeaderItemViewModel && otherItem.text == text

    override fun areContentsUnChanged(otherItem: Any) = areItemsTheSame(otherItem)
}