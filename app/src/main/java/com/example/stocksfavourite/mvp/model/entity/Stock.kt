package com.example.stocksfavourite.mvp.model.entity

data class Stock(val tickerStock: String = "",
                 val logoStock: Int,
                 val company: String = "",
                 val currency: String = "",
                 val currentPrice: Double = 100.1,
                 val priceChangePerDay: Double = 0.01,
                 val favourite: Boolean = false)