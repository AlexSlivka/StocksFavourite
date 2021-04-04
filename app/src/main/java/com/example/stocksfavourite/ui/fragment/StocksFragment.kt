package com.example.stocksfavourite.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.stocksfavourite.R

class StocksFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_stocks, container, false)
        view.findViewById<TextView>(R.id.tv_menu_favourite_on_fragment_of_stocks)
            .setOnClickListener {
                fragmentManager?.beginTransaction()
                    ?.addToBackStack(null)
                    ?.replace(R.id.bottom_container, FavouriteFragment())
                    ?.commit()
            }
        return view
    }
}