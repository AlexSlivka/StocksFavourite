package com.example.stocksfavourite.di.module

import com.example.stocksfavourite.mvp.model.network.INetworkStatus
import com.example.stocksfavourite.mvp.model.api.IDataSource
import com.example.stocksfavourite.mvp.model.cache.IGithubUsersCache
import com.example.stocksfavourite.mvp.model.repo.IGithubUsersRepo
import com.example.stocksfavourite.mvp.model.repo.RetrofitGithubUsersRepo
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepoModule {

    @Singleton
    @Provides
    fun usersRepo(
        api: IDataSource,
        networkStatus: INetworkStatus,
        cache: IGithubUsersCache
    ): IGithubUsersRepo = RetrofitGithubUsersRepo(api, networkStatus, cache)


   /* @Singleton
    @Provides
    fun repositoriesRepo(
        api: IDataSource,
        networkStatus: INetworkStatus,
        cache: IGithubRepositoriesCache
    ): IGithubRepositoriesRepo = RetrofitGithubRepositoriesRepo(api, networkStatus, cache)
*/
}