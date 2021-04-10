package com.example.stocksfavourite.mvp.model.repo

import io.reactivex.rxjava3.core.Single

interface IGithubUsersRepo {
    fun getUsers(): Single<List<GithubUser>>
}