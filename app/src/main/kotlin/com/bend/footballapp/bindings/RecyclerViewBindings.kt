package com.bend.footballapp.bindings

import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import com.bend.footballapp.ui.ItemDiffUtil
import com.bend.footballapp.ui.SmartBindingRecyclerViewAdapter
import me.tatarka.bindingcollectionadapter2.BindingRecyclerViewAdapters
import me.tatarka.bindingcollectionadapter2.ItemBinding


/**
 *
 * FootballApp
 * RecyclerViewBindings
 *
 * Created on 12/07/2017
 *
 */
object RecyclerViewBindings {

    @JvmStatic
    @BindingAdapter("itemBinding", "adapter")
    fun <T : ItemDiffUtil.ComparableItem> setAdapter(recyclerView: RecyclerView, itemBinding: ItemBinding<T>, adapter: SmartBindingRecyclerViewAdapter<T>) {
        BindingRecyclerViewAdapters.setAdapter(recyclerView, itemBinding, null, adapter, null, null)
    }

    @JvmStatic
    @BindingAdapter("itemDecoration")
    fun bindItemDecoration(recyclerView: RecyclerView, itemDecoration: RecyclerView.ItemDecoration) {
        recyclerView.addItemDecoration(itemDecoration)
    }
}