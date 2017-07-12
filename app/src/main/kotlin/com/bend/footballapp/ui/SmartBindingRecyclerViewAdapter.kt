package com.bend.footballapp.ui

import android.support.v7.util.DiffUtil
import me.tatarka.bindingcollectionadapter2.BindingRecyclerViewAdapter


/**
 *
 * FootballApp
 * SmartBindingRecyclerViewAdapter
 *
 * Created on 12/07/2017
 * Copyright (c) 2017 SHAPE A/S. All rights reserved.
 *
 */
class SmartBindingRecyclerViewAdapter<T : ItemDiffUtil.ComparableItem> : BindingRecyclerViewAdapter<T>() {

    var _items: List<T>? = null

    val isEmpty: Boolean
        get() = _items?.isEmpty() ?: true

    fun updateAndDiffItems(newListItems: List<T>) {
        val diffResult = DiffUtil.calculateDiff(ItemDiffUtil(_items, newListItems))
        setItems(newListItems)
        diffResult.dispatchUpdatesTo(this)
    }

    override fun setItems(items: List<T>?) {
        super.setItems(items)

        _items = items
    }

    fun getItems() = _items
}