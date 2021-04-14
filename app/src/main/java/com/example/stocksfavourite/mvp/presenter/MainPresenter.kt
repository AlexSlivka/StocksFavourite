package com.example.stocksfavourite.mvp.presenter

import com.example.stocksfavourite.mvp.model.navigation.IScreens
import com.example.stocksfavourite.mvp.view.MainView
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import javax.inject.Inject

class MainPresenter() : MvpPresenter<MainView>() {

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var screens: IScreens

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(screens.stocks())
    }

    fun backClicked() {
        router.exit()
    }
}