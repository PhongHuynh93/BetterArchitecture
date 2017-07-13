package com.bend.footballapp.bindings

import android.databinding.BindingAdapter
import android.support.v7.widget.Toolbar
import android.view.View


/**
 *
 * FootballApp
 * ToolbarBindings
 *
 * Created on 13/07/2017
 * Copyright (c) 2017 SHAPE A/S. All rights reserved.
 *
 */
object ToolbarBindings {

    @JvmStatic
    @BindingAdapter("onUpClicked")
    fun bindUpClicklistener(toolbar: Toolbar, listener: View.OnClickListener?) {
        listener?.let {
            toolbar.setNavigationOnClickListener(listener)
        }
    }
}