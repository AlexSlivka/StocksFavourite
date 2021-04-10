package com.example.stocksfavourite.di.module

import com.example.stocksfavourite.mvp.model.network.INetworkStatus
import com.example.stocksfavourite.mvp.model.api.IDataSource
import com.example.stocksfavourite.mvp.model.cache.IStocksCache
import com.example.stocksfavourite.mvp.model.repo.IStocksRepo
import com.example.stocksfavourite.mvp.model.repo.RetrofitStocksRepo
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepoModule {

    @Singleton
    @Provides
    fun stocksRepo(
        api: IDataSource,
        networkStatus: INetworkStatus,
        cache: IStocksCache
    ): IStocksRepo = RetrofitStocksRepo(api, networkStatus, cache)


   /* @Singleton
    @Provides
    fun repositoriesRepo(
        api: IDataSource,
        networkStatus: INetworkStatus,
        cache: IGithubRepositoriesCache
    ): IGithubRepositoriesRepo = RetrofitGithubRepositoriesRepo(api, networkStatus, cache)
*/
}