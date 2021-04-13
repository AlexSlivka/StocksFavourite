package com.example.stocksfavourite.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.stocksfavourite.databinding.ItemCtocksBinding
import com.example.stocksfavourite.mvp.presenter.list.IStockListPresenter
import com.example.stocksfavourite.mvp.view.list.StockItemView

class StocksRVAdapter(val presenter: IStockListPresenter) :
    RecyclerView.Adapter<StocksRVAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            ItemCtocksBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        ).apply {
            itemView.setOnClickListener { presenter.itemClickListener?.invoke(this) }
        }

    override fun getItemCount() = presenter.getCount()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        presenter.bindView(holder.apply { pos = position })

    inner class ViewHolder(val vb: ItemCtocksBinding) : RecyclerView.ViewHolder(vb.root),
        StockItemView {
        override fun setTicker(text: String) = with(vb) {
            tvTickerStock.text = text
        }

        override fun setNameCompany(text: String) = with(vb) {
            tvCompanyStock.text = text
        }

        override fun setStarFavourite(favourite: Float) = with(vb) {
            rbStarFavourite.rating = favourite
        }

        override var pos = -1

    }
}

/*
class ReposotoriesRVAdapter(val presenter: IRepositoryListPresenter) : RecyclerView.Adapter<ReposotoriesRVAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(ItemRepositoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)).apply {
            itemView.setOnClickListener { presenter.itemClickListener?.invoke(this) }
        }

    override fun getItemCount() = presenter.getCount()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = presenter.bindView(holder.apply { pos = position })

    inner class ViewHolder(val vb: ItemRepositoryBinding) : RecyclerView.ViewHolder(vb.root), RepositoryItemView {
        override var pos = -1
        override fun setName(text: String) = with(vb) {
            tvName.text = text
        }
    }
}
 */
