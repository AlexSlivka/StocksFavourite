package com.example.stocksfavourite.mvp.model.entity.room.dao

import androidx.room.*
import com.example.stocksfavourite.mvp.model.entity.room.RoomStock

@Dao
interface StockDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(stock: RoomStock)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg stocks: RoomStock)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(stocks: List<RoomStock>)

    @Update
    fun update(stock: RoomStock)

    @Update
    fun update(vararg stocks: RoomStock)

    @Update
    fun update(stocks: List<RoomStock>)

    @Delete
    fun delete(stock: RoomStock)

    @Delete
    fun delete(vararg stocks: RoomStock)

    @Delete
    fun delete(stocks: List<RoomStock>)

    @Query("SELECT * FROM RoomStock")
    fun getAll(): List<RoomStock>

    @Query("SELECT * FROM RoomStock WHERE company = :companyName LIMIT 1")
    fun findByCompany(companyName: String): RoomStock?
}
