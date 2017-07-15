package com.bend.footballapp.viewmodels.items

import android.databinding.ObservableBoolean
import android.text.format.DateUtils
import android.view.View
import com.bend.components.entities.FixtureWithTeams
import com.bend.footballapp.CustomApplication
import com.bend.footballapp.ui.ItemDiffUtil


/**
 *
 * FootballApp
 * FixtureItemViewModel
 *
 * Created on 13/07/2017
 *
 */
class FixtureWithTeamsItemViewModel(val fixtureWithTeams: FixtureWithTeams, val onItemClicked: (FixtureWithTeams) -> Unit) : ItemDiffUtil.ComparableItem {

    val homeTeamName = fixtureWithTeams.homeTeam.teamName
    val awayTeamName = fixtureWithTeams.awayTeam.teamName

    val homeTeamScore = fixtureWithTeams.fixture.result?.scoreHome?.toString()
    val awayTeamScore = fixtureWithTeams.fixture.result?.scoreAway?.toString()

    val startedDateTime = DateUtils.getRelativeTimeSpanString(CustomApplication.get(), fixtureWithTeams.fixture.startTime?.millis!!)

    val isOngoing = ObservableBoolean(fixtureWithTeams.fixture.result?.finished?.not() ?: false)

    fun onItemClicked(view: View) = onItemClicked(fixtureWithTeams)

    override fun areItemsTheSame(otherItem: Any) = otherItem is FixtureWithTeamsItemViewModel && otherItem.fixtureWithTeams.fixture.fixtureId == fixtureWithTeams.fixture.fixtureId

    override fun areContentsUnChanged(otherItem: Any) = otherItem is FixtureWithTeamsItemViewModel && otherItem.fixtureWithTeams == fixtureWithTeams
}