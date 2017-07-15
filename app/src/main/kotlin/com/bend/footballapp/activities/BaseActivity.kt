package com.bend.footballapp.activities

import android.content.Intent
import android.os.Bundle
import android.support.annotation.IntDef
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import com.bend.footballapp.R
import com.bend.footballapp.viewmodels.interfaces.IViewModel


/**
 *
 * FootballApp
 * BaseActivity
 *
 * Created on 12/07/2017
 *
 */
abstract class BaseActivity : AppCompatActivity() {

    protected abstract val viewModel: IViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        handleIntent(intent)

        setContentView(viewModel.inflateView(LayoutInflater.from(this)))
    }

    protected abstract fun handleIntent(intent: Intent)

    override fun onStart() {
        super.onStart()

        viewModel.onStart()
    }

    override fun onBackPressed() {
        finishActivity()
    }

    override fun onStop() {
        super.onStop()

        viewModel.onStop()
    }

    @JvmOverloads protected fun launchActivity(intent: Intent, @Transition animation: Int = IN_FROM_RIGHT) {
        startActivity(intent)
        doTransitionAnimation(animation)
    }

    protected fun launchActivityForResult(intent: Intent, requestCode: Int) {
        startActivityForResult(intent, requestCode)
        doTransitionAnimation(IN_FROM_RIGHT)
    }

    open fun finishActivity() {
        finishActivityWithAnimation(OUT_RIGHT)
    }

    protected fun finishActivityWithAnimation(@Transition transitionAnimation: Int) {
        finish()
        doTransitionAnimation(transitionAnimation)
    }

    private fun doTransitionAnimation(@Transition animation: Int) {
        when (animation) {
            IN_FROM_BOTTOM -> overridePendingTransition(R.anim.in_from_bottom, R.anim.fade_out)
            IN_FROM_RIGHT -> overridePendingTransition(R.anim.in_from_right, R.anim.fade_out)
            OUT_BOTTOM -> overridePendingTransition(R.anim.fade_in, R.anim.out_bottom)
            OUT_RIGHT -> overridePendingTransition(R.anim.fade_in, R.anim.out_right)
        }
    }

    // endregion

    companion object {

        // Used for Fragment and Activity transitions
        @IntDef(IN_FROM_BOTTOM.toLong(), IN_FROM_RIGHT.toLong(), OUT_BOTTOM.toLong(), OUT_RIGHT.toLong())
        annotation class Transition

        const val IN_FROM_BOTTOM = 0
        const val IN_FROM_RIGHT = 1
        const val OUT_BOTTOM = 2
        const val OUT_RIGHT = 3
    }
}