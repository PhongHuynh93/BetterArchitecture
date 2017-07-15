package com.bend.components

import com.bend.components.apis.ApiManager
import com.bend.components.entities.FixtureWithTeams
import com.bend.components.services.NotificationService
import com.bend.components.services.PreferenceService
import com.bend.shared.entities.Fixture
import com.bend.shared.entities.Team
import io.reactivex.Observable
import io.reactivex.functions.BiFunction


/**
 *
 * FootballApp
 * MainComponent
 *
 * Created on 13/07/2017
 * Copyright (c) 2017 SHAPE A/S. All rights reserved.
 *
 */
class MainComponent {

    fun userHasFavoriteTeams() = PreferenceService.retrieveFavoriteTeams().isNotEmpty()

    fun  notifyUser(fixtureWithTeams: FixtureWithTeams) {
        NotificationService.notifyUserOfFixture(fixtureWithTeams)
    }

    fun startReceivingFixtureUpdates(followingFixtureIds: List<Int>) {

        // TODO
    }

    fun stopReceivingFixtureUpdates() {

        // TODO
    }

    fun getFixturesWithTeams(): Observable<List<FixtureWithTeams>> {

        val favoriteTeams = PreferenceService.retrieveFavoriteTeams()

        return ApiManager.fixtureApi.getFixtures()

                // Pull the list of fixtures out of the response
                .map { it.fixtures }

                // Convert them to a list of FixturesWithTeams
                .flatMap { fixtures ->

                    // By turning them into a stream
                    Observable.fromIterable(fixtures)

                            // Filtering only those concerning a favorite team
                            .filter { (_, teamIdHome, teamIdAway) -> favoriteTeams.any { it.teamId == teamIdHome || it.teamId == teamIdAway }}

                            .flatMap {

                                // Have to flat map for the zipWith to apply to each element, not the stream as a whole
                                Observable.just(it)

                                        // Pulling the teams down for each fixture
                                        .zipWith(ApiManager.teamApi.getTeams(), // TODO Caching to avoid the return trips

                                                BiFunction<Fixture, MutableList<Team>, FixtureWithTeams> { fixture, teams ->

                                                    // Create the FixtureWithTeams from the fixture and the matching teams
                                                    FixtureWithTeams(fixture,
                                                            teams.first { (teamId) -> teamId == fixture.teamIdHome },
                                                            teams.first { (teamId) -> teamId == fixture.teamIdAway }
                                                    )
                                                })
                            }

                            // Sort them for the most recent first
                            .sorted { (fixture1), (fixture2) ->
                                return@sorted fixture1.startTime?.compareTo(fixture2.startTime) ?: -1  // Show those with no dates last
                            }

                            .toList()
                            .toObservable()
                }
    }
}