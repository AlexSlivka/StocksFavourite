package com.example.stocksfavourite.ui.navigation

import com.example.stocksfavourite.mvp.model.navigation.IScreens
import com.example.stocksfavourite.ui.fragment.FavouriteFragment
import com.example.stocksfavourite.ui.fragment.StocksFragment
import com.github.terrakok.cicerone.Screen
import com.github.terrakok.cicerone.androidx.FragmentScreen

class AndroidScreens : IScreens {

    override fun stocks() = FragmentScreen { StocksFragment.newInstance() }
    override fun favourite() = FragmentScreen { FavouriteFragment.newInstance() }

    //   override fun repository(githubRepository: GithubRepository) = FragmentScreen { RepositoryFragment.newInstance(githubRepository) }

}