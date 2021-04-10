package com.example.stocksfavourite.mvp.presenter

import com.example.stocksfavourite.mvp.model.entity.Stock
import com.example.stocksfavourite.mvp.model.navigation.IScreens
import com.example.stocksfavourite.mvp.presenter.list.IStockListPresenter
import com.example.stocksfavourite.mvp.view.StocksView
import com.example.stocksfavourite.mvp.view.list.StockItemView
import com.example.stocksfavourite.ui.adapter.StocksRVAdapter
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.core.Scheduler
import moxy.MvpPresenter
import javax.inject.Inject
import javax.inject.Named

class StocksPresenter() : MvpPresenter<StocksView>() {

    @field:Named("ui")
    @Inject
    lateinit var uiScheduler: Scheduler

    //   @Inject lateinit var usersRepo: IGithubUsersRepo
    @Inject
    lateinit var screens: IScreens

    @Inject
    lateinit var router: Router

     class StocksListPresenter : IStockListPresenter {
           val stocks = mutableListOf<Stock>()
           override var itemClickListener: ((StockItemView) -> Unit)? = null

           override fun getCount() = stocks.size

           override fun bindView(view: StocksRVAdapter.ViewHolder) {
               val stock = stocks[view.pos]
               stock.tickerStock.let { view.setTicker(it) }
               stock.company.let {view.setNameCompany(it)}
               view.setStarFavourite(1F)

           }
       }

       val stocksListPresenter = StocksListPresenter()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
            loadData()
              stocksListPresenter.itemClickListener = { itemView ->
                   val stock = stocksListPresenter.stocks[itemView.pos]
                   router.navigateTo(screens.stockCard(stock))
               }
    }

      fun loadData() {
          usersRepo.getUsers()
              .observeOn(uiScheduler)
              .subscribe({ repos ->
                  stocksListPresenter.stocks.clear()
                  stocksListPresenter.stocks.addAll(repos)
                  viewState.updateList()
              }, {
                  println("Error: ${it.message}")
              })
      }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }

    fun toFavourite() {
        router.replaceScreen(screens.favourite())
    }
}
