package com.example.stocksfavourite.model

import com.example.stocksfavourite.R

class Repository {
    fun getStocks(): List<Stock> {
        return listOf(
                Stock("YNDX",
                        R.drawable.logo_yndx,
                        "Yandex, LLC",
                        "P",
                        4764.5,
                        0.02
                ),
                Stock("AAPL",
                        R.drawable.logo_aapl,
                        "Apple Inc",
                        "$",
                        131.93,
                        0.12,
                        true),
                Stock("GOOGL",
                        R.drawable.logo_googl,
                        "Alphabet Class A",
                        "$",
                        1825.0,
                        0.02),
                Stock("AMZN",
                        R.drawable.logo_amzn,
                        "Amazon.com",
                        "$",
                        3256.5,
                        -0.12)
        )
    }
}