package com.bend.components.apis

import com.bend.components.utils.RetryHandler
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Response


/**
 *
 * FootballApp
 * BaseApi
 *
 * Created on 12/07/2017
 * Copyright (c) 2017 SHAPE A/S. All rights reserved.
 *
 */
open class BaseApi {

    protected fun <T> runAsync(single: Single<Response<T>>): Single<T> {
        return single
                .map( { it.body() })
                /*.retryWhen(

                    // Retry three times, unless it's an UnauthorizedException, in which case re-login
                    { it.zipWith({ Observable.range(1, 4) }) { throwable, integer: Int ->

                        // We have to throw the original error on the final try to ensure someone catches it down the line
                        if (integer == 4) throw throwable

                        // This will return an item (retry) for every integer of the range above
                        integer
                    }}
                )*/
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
    }
}