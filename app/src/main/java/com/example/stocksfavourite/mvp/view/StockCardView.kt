package com.example.stocksfavourite.mvp.view

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface StockCardView: MvpView {
    fun init()
    fun setTicker(text: String)
    fun setCompany(text: String)
}



