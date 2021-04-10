package com.example.stocksfavourite.mvp.model.repo

import com.example.stocksfavourite.mvp.model.entity.Stock
import io.reactivex.rxjava3.core.Single

interface IStocksRepo {
    fun getStocks(): Single<List<Stock>>
}