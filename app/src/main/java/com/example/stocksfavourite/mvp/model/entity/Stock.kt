package com.example.stocksfavourite.mvp.model.entity

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Stock(
    @SerializedName("symbol") @Expose val tickerStock: String,
    @SerializedName("description") @Expose val company: String,
    val favourite: Boolean = false
) : Parcelable

