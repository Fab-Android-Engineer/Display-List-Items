package com.example.displayitems.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.displayitems.model.ItemModel
import com.example.displayitems.network.ItemApiService
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception
import javax.inject.Inject

@Module
@InstallIn(SingletonComponent::class)
class ItemRepository @Inject constructor(private val itemApiService: ItemApiService) {
    private var _item = MutableLiveData<List<ItemModel>>() // mutable live data that can be change within the scope of the view model
    val item : LiveData<List<ItemModel>> = _item // view will listen to var item MutableLiveData

    fun getListOfItem()  {
        try {
            return itemApiService.getData().enqueue(object : Callback<List<ItemModel>> {
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
            e.printStackTrace()
        }
    }

    /**
     * this sort the data by id
     */
    object getId {
        fun sortedListById(item: List<ItemModel>) : List<ItemModel>  {
           return item.sortedBy {
                it.listId
            }
        }
    }
    /**
     * this sort the data by name
     */
    object getName {
        fun sortedListByName(item: List<ItemModel>) : List<ItemModel>  {
            val filterList = item.filter {
                !it.name.isNullOrEmpty()
            }
//            filterList.map {
//                it.name = it.name?.substringAfter(" ")
//            }
            filterList.sortedBy {
                it.name
            }
            return filterList
        }
    }
}