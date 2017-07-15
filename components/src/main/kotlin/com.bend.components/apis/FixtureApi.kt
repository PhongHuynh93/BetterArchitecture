package com.bend.components.apis

import com.bend.components.retrofit.Retrofit


/**
 *
 * FootballApp
 * FixtureApi
 *
 * Created on 13/07/2017
 *
 */
class FixtureApi : BaseApi() {

    fun getFixtures() = runAsync(Retrofit.apiService.getFixtures())
}