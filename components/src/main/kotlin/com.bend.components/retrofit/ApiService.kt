package com.bend.components.retrofit

import com.bend.shared.responses.FixturesResponse
import com.bend.shared.responses.TeamsResponse
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET


/**
 *
 * FootballApp
 * ApiService
 *
 * Created on 12/07/2017
 * Copyright (c) 2017 SHAPE A/S. All rights reserved.
 *
 */
interface ApiService {

    @GET("/teams")
    fun getTeams(): Observable<Response<TeamsResponse>>

    @GET("/fixtures")
    fun getFixtures(): Observable<Response<FixturesResponse>>
}