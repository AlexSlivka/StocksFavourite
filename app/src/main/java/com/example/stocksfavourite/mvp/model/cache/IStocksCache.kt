package com.example.stocksfavourite.mvp.model.cache

import com.example.stocksfavourite.mvp.model.entity.Stock
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

interface IStocksCache {
    fun getStocks(): Single<List<Stock>>
    fun putStocks(stocks: List<Stock>) : Completable
}