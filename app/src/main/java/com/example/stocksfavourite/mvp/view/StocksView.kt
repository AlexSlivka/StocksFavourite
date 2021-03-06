package com.example.stocksfavourite.mvp.view

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface StocksView : MvpView {
    fun init()
    fun updateList()
}

