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

/**
 * A simple [Fragment] subclass.
 * Use the [SortedListNameFragment.newInstance] factory method to
 * create an instance of this fragment.
 */

@AndroidEntryPoint
class SortedListNameFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewLayoutManager: RecyclerView.LayoutManager

    private val itemViewModel: ItemViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_sorted_list_name, container, false)
        // setting view type in recycler view
        recyclerView = view.findViewById(R.id.rv_recyclerview)
        viewLayoutManager = LinearLayoutManager(context)
        itemViewModel.item.observe(viewLifecycleOwner) { list ->
            val filterList = list.filter {
                !it.name.isNullOrEmpty()
            }
            filterList.map {
                it.name = it.name?.substringAfter(" ")
            }
            val sortedList = filterList.sortedBy {
                it.name?.toInt()
            }
            viewAdapter = ItemsAdapter(sortedList, true)
            recyclerView.apply {
                layoutManager = viewLayoutManager
                adapter = viewAdapter
            }
        }
        return view
    }
}