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
import com.example.displayitems.repository.ItemRepository.getId.sortedListById
import com.example.displayitems.viewmodel.ItemViewModel
import dagger.hilt.android.AndroidEntryPoint

/**
 * A simple [Fragment] subclass.
 * Use the [SortedList.newInstance] factory method to
 * create an instance of this fragment.
 */
@AndroidEntryPoint
class SortedListIdFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private val itemViewModel : ItemViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_sorted_list_id, container, false)
        recyclerView = view.findViewById(R.id.rv_recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(context)

        itemViewModel.item.observe(viewLifecycleOwner) { list ->
             val sortedId = sortedListById(list)
            recyclerView.adapter = ItemsAdapter(sortedId, false)
        }
        return view

    }

}