package com.example.stocksfavourite.mvp.presenter

import com.example.stocksfavourite.mvp.model.entity.Company
import com.example.stocksfavourite.mvp.model.entity.Stock
import com.example.stocksfavourite.mvp.view.StockCardView
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import javax.inject.Inject

class StockCardPresenter (val stock: Stock) : MvpPresenter<StockCardView>() {

    @Inject
    lateinit var router: Router

   // val companyInfo = Company()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        viewState.setTicker(stock.tickerStock ?: "")
        viewState.setCompany(stock.company ?: "")
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}

/*
(val githubRepository: GithubRepository) : MvpPresenter<RepositoryView>() {

    @Inject lateinit var router: Router

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        viewState.setId(githubRepository.id ?: "")
        viewState.setTitle(githubRepository.name ?: "")
        viewState.setForksCount(githubRepository.forksCount?.toString() ?: "")
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}

 */