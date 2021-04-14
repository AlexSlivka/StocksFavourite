package com.example.stocksfavourite.mvp.model.navigation

import com.example.stocksfavourite.mvp.model.entity.Stock
import com.github.terrakok.cicerone.Screen

interface IScreens {
    fun stocks(): Screen
    fun favourite(): Screen
    fun stockCard(stock: Stock): Screen
    //   fun repository(githubRepository: GithubRepository): Screen

}