package com.example.stocksfavourite.ui

import android.app.Application
import com.example.stocksfavourite.di.AppComponent
import com.example.stocksfavourite.di.DaggerAppComponent
import com.example.stocksfavourite.di.module.AppModule
import com.example.stocksfavourite.mvp.model.entity.room.db.Database

class App : Application() {
    companion object {
        lateinit var instance: App
    }

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        instance = this
        Database.create(this)

        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }
}