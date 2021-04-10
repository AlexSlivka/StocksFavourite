package com.example.stocksfavourite.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.stocksfavourite.databinding.FragmentStockCardBinding
import com.example.stocksfavourite.mvp.model.entity.Stock
import com.example.stocksfavourite.mvp.presenter.StockCardPresenter
import com.example.stocksfavourite.mvp.view.StockCardView
import com.example.stocksfavourite.ui.BackButtonListener
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class StockCardFragment : MvpAppCompatFragment(), StockCardView, BackButtonListener {
    companion object {
        private const val STOCK_CARD_ARG = "stockCard"

        fun newInstance(stock: Stock) = StockCardFragment().apply {
            arguments = Bundle().apply {
                putParcelable(STOCK_CARD_ARG, stock)
            }
        }
    }

    private var vb: FragmentStockCardBinding? = null

    val presenter: StockCardPresenter by moxyPresenter {
        val repository = arguments?.getParcelable<Stock>(STOCK_CARD_ARG) as Stock
        StockCardPresenter(repository)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) =
        FragmentStockCardBinding.inflate(inflater, container, false).also {
            vb = it
        }.root

    override fun init() {}
    override fun setTicker(text: String) {
        vb?.tvTickerStockCard?.text = text
    }

    override fun setCompany(text: String) {
        vb?.tvCompanyStockCard?.text = text
    }

    override fun backPressed() = presenter.backPressed()
}


/*
class RepositoryFragment : MvpAppCompatFragment(), RepositoryView, BackButtonListener {

    companion object {
        private const val REPOSITORY_ARG = "repository"

        fun newInstance(repository: GithubRepository) = RepositoryFragment().apply {
            arguments = Bundle().apply {
                putParcelable(REPOSITORY_ARG, repository)
            }
        }
    }

    private var vb: FragmentRepositoryBinding? = null

    val presenter: RepositoryPresenter by moxyPresenter {
        val repository = arguments?.getParcelable<GithubRepository>(REPOSITORY_ARG) as GithubRepository
        RepositoryPresenter(repository)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        FragmentRepositoryBinding.inflate(inflater, container, false).also {
            vb = it
        }.root

    override fun init() {}

    override fun setId(text: String) {
       vb?.tvId?.text = text
    }

    override fun setTitle(text: String) {
        vb?.tvTitle?.text = text
    }

    override fun setForksCount(text: String) {
        vb?.tvForksCount?.text = text
    }

    override fun backPressed() = presenter.backPressed()
}
 */