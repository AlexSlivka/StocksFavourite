package com.example.stocksfavourite.mvp.model.cache.room

import com.example.stocksfavourite.mvp.model.entity.room.db.Database
import com.example.stocksfavourite.mvp.model.cache.IStocksCache
import com.example.stocksfavourite.mvp.model.entity.Stock
import com.example.stocksfavourite.mvp.model.entity.room.RoomStock
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class RoomStocksCache(val db: Database) : IStocksCache {

    override fun getStocks() = Single.fromCallable {
        db.stockDao.getAll().map { roomStock ->
            Stock(roomStock.tickerStock, roomStock.company, roomStock.favourite)
        }
    }

    override fun putStocks(stocks: List<Stock>) = Completable.fromAction {
        val roomStocks = stocks.map { user ->
            RoomStock(
                user.tickerStock,
                user.company,
                user.favourite
            )

        }
        db.stockDao.insert(roomStocks)
    }.subscribeOn(Schedulers.io())
}