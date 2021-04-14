package com.example.stocksfavourite.ui.navigation

import com.example.stocksfavourite.mvp.model.entity.Stock
import com.example.stocksfavourite.mvp.model.navigation.IScreens
import com.example.stocksfavourite.ui.fragment.FavouriteFragment
import com.example.stocksfavourite.ui.fragment.StockCardFragment
import com.example.stocksfavourite.ui.fragment.StocksFragment
import com.github.terrakok.cicerone.Screen
import com.github.terrakok.cicerone.androidx.FragmentScreen

class AndroidScreens : IScreens {

    override fun stocks() = FragmentScreen { StocksFragment.newInstance() }
    override fun favourite() = FragmentScreen { FavouriteFragment.newInstance() }
    override fun stockCard(stock: Stock) = FragmentScreen { StockCardFragment.newInstance(stock) }

    //   override fun repository(githubRepository: GithubRepository) = FragmentScreen { RepositoryFragment.newInstance(githubRepository) }

}