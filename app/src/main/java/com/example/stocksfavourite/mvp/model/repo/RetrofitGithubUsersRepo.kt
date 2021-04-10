package com.example.stocksfavourite.mvp.model.repo

import com.example.stocksfavourite.mvp.model.api.IDataSource
import com.example.stocksfavourite.mvp.model.cache.IGithubUsersCache
import com.example.stocksfavourite.mvp.model.network.INetworkStatus
import io.reactivex.rxjava3.schedulers.Schedulers

class RetrofitGithubUsersRepo(
    val api: IDataSource,
    val networkStatus: INetworkStatus,
    val cache: IGithubUsersCache
) :
    IGithubUsersRepo {
    override fun getUsers() = networkStatus.isOnlineSingle().flatMap { isOnline ->
        if (isOnline) {
            api.getStocks()
                .flatMap { users ->
                    cache.putUsers(users).toSingleDefault(users)
                }
        } else {
            cache.getUsers()
        }
    }.subscribeOn(Schedulers.io())
}