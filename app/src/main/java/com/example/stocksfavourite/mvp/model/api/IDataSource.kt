package com.example.stocksfavourite.mvp.model.api

import com.example.stocksfavourite.mvp.model.entity.Company
import com.example.stocksfavourite.mvp.model.entity.Stock
import com.google.gson.annotations.Expose
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query
import retrofit2.http.Url

interface IDataSource {

    @GET("stock/symbol?exchange=US")
    fun getStocks(@Header("X-Finnhub-Token") token: String): Single<List<Stock>>

    @GET("stock/profile2?")
    fun getCompanyInfo(@Header("X-Finnhub-Token") token: String, @Query("symbol") ticker: String): Single<Company>

   // @GET
  //  fun getRepositories(@Url url: String): Single<List<GithubRepository>>
}

/*
  @GET("stock/symbol?exchange=US&token=c1njd6q37fkveu5j54pg")
    fun getStocks(): Single<List<Stock>>
 */


//https://finnhub.io/api/v1/stock/symbol?exchange=US&token=c1njd6q37fkveu5j54pg
//https://finnhub.io/api/v1/stock/profile2?symbol=AAPL&token=c1njd6q37fkveu5j54pg