package com.example.stocksfavourite.mvp.view.list

interface StockItemView : IItemView {
    fun setTicker(text: String)
    fun setNameCompany (text: String)
    fun setStarFavourite (favourite:Float)
}