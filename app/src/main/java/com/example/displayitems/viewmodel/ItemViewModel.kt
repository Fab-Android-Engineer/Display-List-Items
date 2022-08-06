package com.example.displayitems.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.displayitems.model.ItemModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import com.example.displayitems.repository.ItemRepository
import javax.inject.Inject

@HiltViewModel
class ItemViewModel @Inject constructor(private val itemRepository: ItemRepository) : ViewModel() {
//    val item = itemRepository.item // this call Item that holds a liveData list of item from repository
    val item: LiveData<List<ItemModel>> = itemRepository.item

    /**
     * call the getItemList() on init so it display status immediately
     */
    init {
        getItemList()
    }
    /**
     * this gets the data information from the Api
     */
    private fun getItemList () {
        viewModelScope.launch {
            itemRepository.getListOfItem()
        }
    }
}