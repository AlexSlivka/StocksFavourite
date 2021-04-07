package com.example.stocksfavourite.mvp.presenter

import com.example.stocksfavourite.mvp.model.navigation.IScreens
import com.example.stocksfavourite.mvp.view.StocksView
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

    /*   class UsersListPresenter : IUserListPresenter {
           val users = mutableListOf<GithubUser>()
           override var itemClickListener: ((UserItemView) -> Unit)? = null

           override fun getCount() = users.size

           override fun bindView(view: UserItemView) {
               val user = users[view.pos]
               user.login?.let { view.setLogin(it) }
               user.avatarUrl?.let {view.loadAvatar(it)}
           }
       }

       val usersListPresenter = UsersListPresenter()
   */
    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        //     loadData()

        /*       usersListPresenter.itemClickListener = { itemView ->
                   val user = usersListPresenter.users[itemView.pos]
                   router.navigateTo(screens.user(user))
               }*/
    }

    /*  fun loadData() {
          usersRepo.getUsers()
              .observeOn(uiScheduler)
              .subscribe({ repos ->
                  usersListPresenter.users.clear()
                  usersListPresenter.users.addAll(repos)
                  viewState.updateList()
              }, {
                  println("Error: ${it.message}")
              })
      } */

    fun backPressed(): Boolean {
        router.exit()
        return true
    }

    fun toFavourite() {
        router.replaceScreen(screens.favourite())
    }
}
