package com.example.stocksfavourite.mvp.model.entity.room

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity
class RoomStock(
    @PrimaryKey val tickerStock: String,
    val company: String,
    val favourite: Boolean
)

