package com.example.displayitems.network

import com.example.displayitems.model.ItemModel
import retrofit2.Call

import retrofit2.http.GET

interface ItemApiService  {
    @GET("hiring.json")
    fun getData(): Call<List<ItemModel>>
}
