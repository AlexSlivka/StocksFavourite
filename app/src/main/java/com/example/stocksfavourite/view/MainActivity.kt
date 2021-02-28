package com.example.stocksfavourite.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.stocksfavourite.R
import com.example.stocksfavourite.view.fragments.MainSearchFragment
import com.example.stocksfavourite.view.fragments.StocksFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .add(R.id.top_container, MainSearchFragment())
                    .add(R.id.bottom_container, StocksFragment())
                    .commit()
        }
    }
}