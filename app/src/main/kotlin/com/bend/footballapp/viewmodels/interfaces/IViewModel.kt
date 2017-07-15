package com.bend.footballapp.viewmodels.interfaces

import android.databinding.ViewDataBinding
import android.view.LayoutInflater
import android.view.View


/**
 *
 * FootballApp
 * IViewModel
 *
 * Created on 12/07/2017
 *
 */
interface IViewModel {
    fun inflateView(inflater: LayoutInflater): View
    fun getBinding(): ViewDataBinding?
    fun onStart()
    fun onStop()
    fun onBackPressed(): Boolean
}
