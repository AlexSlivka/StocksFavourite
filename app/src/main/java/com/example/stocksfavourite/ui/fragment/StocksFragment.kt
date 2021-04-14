package com.example.stocksfavourite.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.stocksfavourite.databinding.FragmentStocksBinding
import com.example.stocksfavourite.mvp.presenter.StocksPresenter
import com.example.stocksfavourite.mvp.view.StocksView
import com.example.stocksfavourite.ui.App
import com.example.stocksfavourite.ui.BackButtonListener
import com.example.stocksfavourite.ui.adapter.StocksRVAdapter
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class StocksFragment : MvpAppCompatFragment(), StocksView, BackButtonListener {
    companion object {
        fun newInstance() = StocksFragment()
    }

    val presenter: StocksPresenter by moxyPresenter {
        StocksPresenter().apply {
            App.instance.appComponent.inject(this)
        }
    }

    var adapter: StocksRVAdapter? = null
    private var vb: FragmentStocksBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = FragmentStocksBinding.inflate(inflater, container, false).also {
            vb = it
        }.root
        vb?.tvMenuFavouriteOnFragmentOfStocks?.setOnClickListener { presenter.toFavourite() }
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        vb = null
    }

    override fun init() {
        vb?.rvStocksList?.layoutManager = LinearLayoutManager(context)
        adapter = StocksRVAdapter(
            presenter.stocksListPresenter
        ).apply { App.instance.appComponent.inject(this) }

        vb?.rvStocksList?.adapter = adapter


    }

    override fun updateList() {
        adapter?.notifyDataSetChanged()
    }

    override fun backPressed() = presenter.backPressed()
}
