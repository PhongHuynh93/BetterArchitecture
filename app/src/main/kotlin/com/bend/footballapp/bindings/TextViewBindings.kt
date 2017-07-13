package com.bend.footballapp.bindings

import android.databinding.BindingAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bend.footballapp.R
import com.bend.footballapp.utils.getColor


/**
 *
 * FootballApp
 * TextViewBindings
 *
 * Created on 13/07/2017
 * Copyright (c) 2017 SHAPE A/S. All rights reserved.
 *
 */
object TextViewBindings {

    @JvmStatic
    @BindingAdapter("textHighlighted")
    fun bindImageResource(textView: TextView, highlighted: Boolean) {
        textView.setTextColor(getColor(if (highlighted) R.color.colorAccent else R.color.primary_text_default_material_light))
    }
}