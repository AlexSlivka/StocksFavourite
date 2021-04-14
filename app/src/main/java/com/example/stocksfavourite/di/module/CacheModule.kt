package com.example.stocksfavourite.di.module

import com.example.stocksfavourite.mvp.model.entity.room.db.Database
import androidx.room.Room
import com.example.stocksfavourite.mvp.model.cache.IStocksCache
import com.example.stocksfavourite.mvp.model.cache.room.RoomStocksCache
import com.example.stocksfavourite.ui.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheModule {

    @Singleton
    @Provides
    fun database(app: App) = Room.databaseBuilder(app, Database::class.java, Database.DB_NAME)
        .build()

    @Singleton
    @Provides
    fun stocksCache(db: Database): IStocksCache = RoomStocksCache(db)

 /*   @Singleton
    @Provides
    fun repositoriesCache(db: Database): IGithubRepositoriesCache = RoomGithubRepositoriesCache(db)
*/
}