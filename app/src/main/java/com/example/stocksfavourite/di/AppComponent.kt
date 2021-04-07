package com.example.stocksfavourite.di

import com.example.stocksfavourite.di.module.AppModule
import com.example.stocksfavourite.di.module.CiceroneModule
import com.example.stocksfavourite.mvp.presenter.FavouritePresenter
import com.example.stocksfavourite.mvp.presenter.StocksPresenter
import com.example.stocksfavourite.ui.activity.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        CiceroneModule::class
    ]
)

interface AppComponent {

    fun inject(mainActivity: MainActivity)
    fun inject(stocksPresenter: StocksPresenter)
    fun inject(favouritePresenter: FavouritePresenter)
}