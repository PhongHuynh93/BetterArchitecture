package com.bend.footballapp.viewmodels

import android.view.View
import com.bend.components.MainComponent
import com.bend.components.entities.FixtureWithTeams
import com.bend.footballapp.BR
import com.bend.footballapp.R
import com.bend.footballapp.ui.ItemDiffUtil
import com.bend.footballapp.ui.SmartBindingRecyclerViewAdapter
import com.bend.footballapp.viewmodels.items.FixtureWithTeamsItemViewModel
import com.bend.footballapp.viewmodels.items.HeaderItemViewModel
import me.tatarka.bindingcollectionadapter2.ItemBinding


/**
 *
 * FootballApp
 * MainViewModel
 *
 * Created on 12/07/2017
 *
 */
class MainViewModel(val component: MainComponent, val listener: Listener) : BaseViewModel() {

    interface Listener {
        fun openSelectFavoriteTeamsScreen()
    }

    val itemBinding = ItemBinding.of<ItemDiffUtil.ComparableItem>{ itemBinding, position, item ->
        when (item) {
            is HeaderItemViewModel -> itemBinding.set(BR.viewModel, R.layout.item_header)
            is FixtureWithTeamsItemViewModel -> itemBinding.set(BR.viewModel, R.layout.item_fixture_with_teams)
        }
    }
    val adapter = SmartBindingRecyclerViewAdapter<ItemDiffUtil.ComparableItem>()

    override val bindingLayoutRes = R.layout.view_main

    override fun onStart() {
        super.onStart()

        if (!component.userHasFavoriteTeams()) {
            listener.openSelectFavoriteTeamsScreen()
        }

        showLoading()
        fetchFixtures()
    }

    private fun fetchFixtures() {
        handleDisposal(component.getFixturesWithTeams()
                .subscribe({
                    setContent(it)
                }, {
                    handleError(it)
                }))
    }

    private fun setContent(fixtures: List<FixtureWithTeams>) {

        val ongoingFixtures = fixtures.filter { it.fixture.result?.finished?.not() ?: false }
        val upcomingFixtures = fixtures.filter { it.fixture.startTime?.isAfterNow ?: false }
        val otherFixtures = fixtures.filter { ongoingFixtures.contains(it).not() && upcomingFixtures.contains(it).not() }

        val items = mutableListOf<ItemDiffUtil.ComparableItem>()

        if (ongoingFixtures.isNotEmpty()) items += HeaderItemViewModel("Ongoing")
        items += ongoingFixtures.map { FixtureWithTeamsItemViewModel(it, {
            component.notifyUser(it)
        }) }

        if (upcomingFixtures.isNotEmpty()) items += mutableListOf(HeaderItemViewModel("Upcoming"))
        items += upcomingFixtures.map { FixtureWithTeamsItemViewModel(it, {}) }

        if (otherFixtures.isNotEmpty()) items += mutableListOf(HeaderItemViewModel("Past"))
        items += otherFixtures.map { FixtureWithTeamsItemViewModel(it, {}) }

        adapter.setItems(items)
        showContent()
    }

    fun onSelectTeamsClicked(view: View) {
        listener.openSelectFavoriteTeamsScreen()
    }
}