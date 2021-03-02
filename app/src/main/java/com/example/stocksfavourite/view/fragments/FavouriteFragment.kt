package com.example.stocksfavourite.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.stocksfavourite.R

class FavouriteFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_favourite, container, false)
        view.findViewById<TextView>(R.id.tv_menu_stocks_on_fragment_of_favourite)
            .setOnClickListener {
                fragmentManager?.popBackStack()
            }
        return view
    }
}