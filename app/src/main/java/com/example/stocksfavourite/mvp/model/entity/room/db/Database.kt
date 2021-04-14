package com.example.stocksfavourite.mvp.model.entity.room.db

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.stocksfavourite.mvp.model.entity.room.RoomStock
import com.example.stocksfavourite.mvp.model.entity.room.dao.StockDao

@androidx.room.Database(
    entities = [RoomStock::class],  //entities = [RoomGithubUser::class, RoomGithubRepository::class, RoomCachedImage::class],
    version = 1
)
abstract class Database : RoomDatabase() {
    abstract val stockDao: StockDao
    // abstract val repositoryDao: RepositoryDao
    // abstract val imageDao: ImageDao

    companion object {
        const val DB_NAME = "database.db"
        private var instance: Database? = null
        fun getInstance() = instance
            ?: throw RuntimeException("Database has not been created. Please call create(context)")

        fun create(context: Context?) {
            if (instance == null) {
                instance = Room.databaseBuilder(context!!, Database::class.java, DB_NAME)
                    .build()
            }
        }
    }
}