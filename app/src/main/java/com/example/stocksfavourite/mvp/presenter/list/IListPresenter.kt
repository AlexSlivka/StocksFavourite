package com.example.stocksfavourite.mvp.presenter.list

import com.example.stocksfavourite.ui.adapter.StocksRVAdapter

interface IListPresenter<V> {
    var itemClickListener: ((V) -> Unit)?
    fun bindView(view: StocksRVAdapter.ViewHolder)
    fun getCount(): Int
}