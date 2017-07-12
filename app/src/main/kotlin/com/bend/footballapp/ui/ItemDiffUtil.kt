package com.bend.footballapp.ui

import android.support.v7.util.DiffUtil


/**
 *
 * FootballApp
 * ItemDiffUtil
 *
 * Created on 12/07/2017
 * Copyright (c) 2017 SHAPE A/S. All rights reserved.
 *
 */
class ItemDiffUtil<T : ItemDiffUtil.ComparableItem>(private val _OldList: List<T>?, private val _NewList: List<T>?) : DiffUtil.Callback() {

    interface ComparableItem {
        fun areItemsTheSame(otherItem: Any): Boolean
        fun areContentsUnChanged(otherItem: Any): Boolean
    }

    override fun getOldListSize(): Int {
        return _OldList?.size ?: 0
    }

    override fun getNewListSize(): Int {
        return _NewList?.size ?: 0
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return _NewList!![newItemPosition].areItemsTheSame(_OldList!![oldItemPosition])
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return _NewList!![newItemPosition].areContentsUnChanged(_OldList!![oldItemPosition])
    }

    class SimpleComparableItem : ComparableItem {
        override fun areItemsTheSame(otherItem: Any): Boolean {
            return false
        }

        override fun areContentsUnChanged(otherItem: Any): Boolean {
            return false
        }
    }
}
