package com.bend.footballapp.activities

import android.content.Intent
import com.bend.components.MainComponent
import com.bend.footballapp.viewmodels.MainViewModel

class MainActivity : BaseActivity() {

    override val viewModel = MainViewModel(MainComponent())

    override fun handleIntent(intent: Intent) {}
}
