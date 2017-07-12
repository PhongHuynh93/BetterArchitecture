package com.bend.footballapp.activities

import android.content.Intent
import com.bend.footballapp.viewmodels.MainViewModel

class MainActivity : BaseActivity() {

    override val viewModel = MainViewModel()

    override fun handleIntent(intent: Intent) {}
}
