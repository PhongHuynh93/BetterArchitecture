package com.bend.components.services

import android.app.NotificationManager
import android.content.Context
import android.support.v7.app.NotificationCompat
import com.bend.components.entities.FixtureWithTeams
import com.bendlh.components.R


/**
 *
 * FootballApp
 * NotificationService
 *
 * Created on 13/07/2017
 * Copyright (c) 2017 SHAPE A/S. All rights reserved.
 *
 */
object NotificationService {

    private lateinit var _context: Context
    private lateinit var _notificationManager: NotificationManager

    fun initialise(context: Context) {
        _context = context
        _notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    }

    fun notifyUserOfFixture(fixtureWithTeams: FixtureWithTeams) {

        val notificationId = fixtureWithTeams.fixture.fixtureId

        val builder = NotificationCompat.Builder(_context)
                .setContentTitle(fixtureWithTeams.homeTeam.teamName + " scored!!")
                .setContentText(
                        fixtureWithTeams.fixture.result?.scoreHome.toString() + " - " + fixtureWithTeams.fixture.result?.scoreAway.toString()
                        + ": "
                        + fixtureWithTeams.homeTeam.teamName + " vs " + fixtureWithTeams.awayTeam.teamName)
                .setSmallIcon(R.drawable.ic_notification)
                .setColor(R.color.notification_color)

        _notificationManager.notify(notificationId, builder.build())
    }
}