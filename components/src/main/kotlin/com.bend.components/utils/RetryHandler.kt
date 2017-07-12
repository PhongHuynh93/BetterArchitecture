package com.bend.components.utils

import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.Single
import io.reactivex.functions.Function


/**
 *
 * FootballApp
 * RetryHandler
 *
 * Created on 12/07/2017
 * Copyright (c) 2017 SHAPE A/S. All rights reserved.
 *
 */
class RetryHandler : Function<Single<Throwable>, Single<*>> {

    @Throws(Exception::class)
    override fun apply(throwableSingle: Single<Throwable>): Single<*> {

        // Retry three times, unless it's an UnauthorizedException, in which case re-login
        return throwableSingle.zipWith({ Observable.range(1, 4) }) { throwable, integer: Int ->

            // We have to throw the original error on the final try to ensure someone catches it down the line
            if (integer == 4) throw throwable

            // This will return an item (retry) for every integer of the range above
            integer
        }
    }
}
