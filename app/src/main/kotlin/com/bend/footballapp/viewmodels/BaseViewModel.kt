package com.bend.footballapp.viewmodels

import android.databinding.DataBindingUtil
import android.databinding.ObservableInt
import android.databinding.ViewDataBinding
import android.support.annotation.CallSuper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import com.bend.footballapp.BR
import com.bend.footballapp.CustomApplication
import com.bend.footballapp.viewmodels.interfaces.IViewModel
import io.reactivex.disposables.Disposable


/**
 *
 * FootballApp
 * BaseViewModel
 *
 * Created on 12/07/2017
 *
 */
abstract class BaseViewModel : IViewModel {

    var loadingState = ObservableInt(STATE_LOADING)

    private var _binding: ViewDataBinding? = null

    /**
     * List of disposables (Observables) to be disposed when ViewModel is stopped (Requests that need to be canceled when we leave the screen)
     */
    private val _toDispose = mutableListOf<Disposable>()

    // region View inflation

    /**
     * Returns the binding layout resource Id (R.layout.{view_resource})
     */
    protected abstract val bindingLayoutRes: Int

    override fun inflateView(inflater: LayoutInflater): View {
        _binding = DataBindingUtil.inflate<ViewDataBinding>(inflater, bindingLayoutRes, null, false)
        _binding!!.setVariable(BR.viewModel, this)
        return _binding!!.root
    }

    /**
     * Returns the ViewModels View from it's binding.
     * @return The view root, or null if the binding hasn't been inflated
     */
    override fun getBinding(): ViewDataBinding? {
        return _binding
    }

    // endregion

    // region Loader

    /**
     * Shows the loading state of view_loading, if it's included in the ViewModels layout
     */
    fun showLoading() = loadingState.set(STATE_LOADING)

    /**
     * Shows the empty state of view_loading, if it's included in the ViewModels layout
     */
    fun showNoContent() = loadingState.set(STATE_EMPTY)

    /**
     * Hides all states of view_loading, if it's included in the ViewModels layout
     */
    fun showContent() = loadingState.set(STATE_LOADED)

    // endregion

    // region Network call handling

    /**
     * Must be called with the Disposable return value of any Observable.subscribe() call, to ensure any asnyc work is cancelled when the ViewModel is stopped (ie. we change screen)
     * @param disposable The disposable to dispose off when leaving the screen
     */
    protected fun handleDisposal(disposable: Disposable) = _toDispose.add(disposable)

    /**
     * Logs and shows a toast to the user relating to the error and calls showNoContent(). In some cases may also show a dialog
     * @param error The error to handle
     */
    @CallSuper
    open fun handleError(error: Throwable) {
        Toast.makeText(CustomApplication.get(), "Error: " + error.message, Toast.LENGTH_SHORT).show()
        Log.e(this.toString(), error.toString())
        showNoContent()
    }

    // endregion

    // region Lifecycle methods

    @CallSuper
    override fun onStart() {}

    override fun onBackPressed() =  false

    /**
     * Must be called to ensure any async work currently running is cancelled so as to avoid it returning with the view in a unusable state
     */
    @CallSuper
    override fun onStop() {

        // These are our observables for pending network requests, we want to dispose (cancel) of them when onStop is called
        _toDispose
                .filterNot { it.isDisposed }
                .forEach { it.dispose() }
        _toDispose.clear()
    }

    // endregion

    companion object {

        @JvmStatic
        val STATE_LOADED = 0

        @JvmStatic
        val STATE_LOADING = 1

        @JvmStatic
        val STATE_FAILED = 2

        @JvmStatic
        val STATE_EMPTY = 3
    }

    // endregion
}