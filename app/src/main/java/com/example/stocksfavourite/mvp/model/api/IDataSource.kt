package com.example.stocksfavourite.mvp.model.api

import com.example.stocksfavourite.mvp.model.entity.Stock
import com.google.gson.annotations.Expose
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Url

interface IDataSource {
    val token: String
        get() = "c1njd6q37fkveu5j54pg"

    @GET("stock/symbol?exchange=US&token=c1njd6q37fkveu5j54pg")
    fun getStocks(): Single<List<Stock>>

    @GET("stock/symbol?exchange=US")
    fun getStocksAll(@Header("X-Finnhub-Token") token: String): Single<List<Stock>>

   // @GET
  //  fun getRepositories(@Url url: String): Single<List<GithubRepository>>
}

//https://finnhub.io/api/v1/stock/symbol?exchange=US&token=c1njd6q37fkveu5j54pg