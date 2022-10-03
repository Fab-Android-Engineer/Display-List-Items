package com.example.displayitems.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.displayitems.R
import com.example.displayitems.repository.ItemRepository.getAllItem.sortAllItem
import com.example.displayitems.viewmodel.ItemViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DisplayAllFragment : Fragment() {
    private val itemViewModel by viewModels<ItemViewModel>()
    private lateinit var  recyclerView : RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.display_all_fragment, container, false)

        recyclerView = view.findViewById(R.id.rv_recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(context)
        //viewLifecycleOwner getting the lifecycle of the activity
        itemViewModel.item.observe(viewLifecycleOwner) { list ->
            val sortAll = sortAllItem(list)
            recyclerView.adapter = DisplayAllAdapter(sortAll)
        }
        // Inflate the layout for this fragment
        return view
    }

}