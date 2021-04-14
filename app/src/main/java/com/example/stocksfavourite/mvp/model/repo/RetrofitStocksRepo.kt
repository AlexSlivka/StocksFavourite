package com.example.stocksfavourite.mvp.model.repo

import com.example.stocksfavourite.mvp.model.api.IDataSource
import com.example.stocksfavourite.mvp.model.api.Token
import com.example.stocksfavourite.mvp.model.cache.IStocksCache
import com.example.stocksfavourite.mvp.model.network.INetworkStatus
import io.reactivex.rxjava3.schedulers.Schedulers

class RetrofitStocksRepo(
    val api: IDataSource,
    val networkStatus: INetworkStatus,
    val cache: IStocksCache
) : IStocksRepo {
    override fun getStocks() = networkStatus.isOnlineSingle().flatMap { isOnline ->
        if (isOnline) {
            api.getStocks(Token.TOKEN_API_FINNHUB)
                .flatMap { stocks ->
                    cache.putStocks(stocks).toSingleDefault(stocks)
                }
        } else {
            cache.getStocks()
        }
    }.subscribeOn(Schedulers.io())
}