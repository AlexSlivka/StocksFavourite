package com.example.stocksfavourite.di

import com.example.stocksfavourite.di.module.ApiModule
import com.example.stocksfavourite.di.module.AppModule
import com.example.stocksfavourite.di.module.CiceroneModule
import com.example.stocksfavourite.mvp.presenter.FavouritePresenter
import com.example.stocksfavourite.mvp.presenter.MainPresenter
import com.example.stocksfavourite.mvp.presenter.StocksPresenter
import com.example.stocksfavourite.ui.activity.MainActivity
import com.example.stocksfavourite.ui.adapter.StocksRVAdapter
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        CiceroneModule::class,
        ApiModule::class
    ]
)

interface AppComponent {

    fun inject(mainActivity: MainActivity)
    fun inject(mainPresenter: MainPresenter)
    fun inject(stocksPresenter: StocksPresenter)
    fun inject(favouritePresenter: FavouritePresenter)
    fun inject(stocksRVAdapter: StocksRVAdapter)
}