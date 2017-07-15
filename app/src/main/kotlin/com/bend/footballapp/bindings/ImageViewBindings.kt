package com.bend.footballapp.bindings

import android.databinding.BindingAdapter
import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.bend.footballapp.R
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy


/**
 *
 * FootballApp
 * ImageViewBindings
 *
 * Created on 13/07/2017
 *
 */
object ImageViewBindings {

    @JvmStatic
    @BindingAdapter("selectedIcon")
    fun bindSelectedIcon(imageView: ImageView, selected: Boolean) {
        imageView.setImageResource(if (selected) R.drawable.ic_selected_enabled else R.drawable.ic_selected_disabled)
    }

    @JvmStatic
    @BindingAdapter("srcCompat")
    fun bindImageResource(imageView: ImageView, resourceId: Int) {
        imageView.setImageResource(resourceId)
    }

    @JvmStatic
    @BindingAdapter("srcCompat")
    fun bindImageResource(imageView: ImageView, drawable: Drawable) {
        imageView.setImageDrawable(drawable)
    }

    @JvmStatic
    @BindingAdapter("srcCompat")
    fun bindImageResource(imageView: ImageView, imageUrl: String) {
        Glide.with(imageView.context)
                .load(imageUrl)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE) //This is for removing the grey-ish background that appears behind images
                .into(imageView)
    }
}