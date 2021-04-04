package com.example.stocksfavourite.mvp.model.navigation

import com.github.terrakok.cicerone.Screen

interface IScreens {
    fun stocks(): Screen
    fun favourite(): Screen
    //   fun repository(githubRepository: GithubRepository): Screen

}