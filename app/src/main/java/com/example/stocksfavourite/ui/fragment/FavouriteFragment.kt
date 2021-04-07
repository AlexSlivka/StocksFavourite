package com.example.stocksfavourite.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.stocksfavourite.R
import com.example.stocksfavourite.databinding.FragmentFavouriteBinding
import com.example.stocksfavourite.databinding.FragmentStocksBinding
import com.example.stocksfavourite.mvp.presenter.FavouritePresenter
import com.example.stocksfavourite.mvp.presenter.StocksPresenter
import com.example.stocksfavourite.mvp.view.FavouriteView
import com.example.stocksfavourite.mvp.view.StocksView
import com.example.stocksfavourite.ui.App
import com.example.stocksfavourite.ui.BackButtonListener
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class FavouriteFragment : MvpAppCompatFragment(), FavouriteView, BackButtonListener {
    companion object {
        fun newInstance() = FavouriteFragment()
    }

    val presenter: FavouritePresenter by moxyPresenter {
        FavouritePresenter().apply {
            App.instance.appComponent.inject(this)
        }
    }

    //    var adapter: UsersRVAdapter? = null
    private var vb: FragmentFavouriteBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = FragmentFavouriteBinding.inflate(inflater, container, false).also {
            vb = it
        }.root
        vb?.tvMenuStocksOnFragmentOfFavourite?.setOnClickListener { presenter.toStocks() }
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        vb = null
    }

    override fun initFavourite() {
        /*   vb?.rvUsers?.layoutManager = LinearLayoutManager(context)
           adapter = UsersRVAdapter(
               presenter.usersListPresenter
           ).apply { App.instance.appComponent.inject(this) }

           vb?.rvUsers?.adapter = adapter

         */
    }

    override fun updateListFavourite() {
        //  adapter?.notifyDataSetChanged()
    }

    override fun backPressed() = presenter.backPressed()
}