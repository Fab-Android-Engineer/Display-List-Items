package com.example.displayitems.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.displayitems.model.ItemModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import com.example.displayitems.network.ItemApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class ItemViewModel @Inject constructor(private val itemApiService: ItemApiService) : ViewModel() {

    private var _item = MutableLiveData<List<ItemModel>>() // mutable live data that can be change within the scope of the view model
    val item : LiveData<List<ItemModel>> = _item // view will listen to val item

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
            try {
                itemApiService.getData().enqueue(object : Callback<List<ItemModel>> {
                    override fun onResponse(
                        call: Call<List<ItemModel>>,
                        response: Response<List<ItemModel>>
                    ) {
                        Log.i("response", "data: ${response.body()}")
                        _item.postValue(response.body())
                    }
                    override fun onFailure(call: Call<List<ItemModel>>, t: Throwable) {
                        t.printStackTrace()
                    }
                })
            } catch (e: Exception) {

            }
        }
    }
}