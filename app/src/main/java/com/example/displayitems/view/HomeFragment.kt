package com.example.displayitems.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.displayitems.R
import com.example.displayitems.viewmodel.ItemViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint // dagger knows that to inject the view Model
class HomeFragment : Fragment() {

    private val itemViewModel by viewModels<ItemViewModel>()
    private lateinit var  recyclerView : RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        recyclerView = view.findViewById(R.id.rv_recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(context)
        //viewLifecycleOwner getting the lifecycle of the activity
        itemViewModel.item.observe(viewLifecycleOwner) {
            recyclerView.adapter = ItemsAdapter(it, false)
        }
        // Inflate the layout for this fragment
        return view
    }
}