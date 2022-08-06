package com.example.displayitems.network

import com.example.displayitems.model.ItemModel
import retrofit2.Call

import retrofit2.http.GET

interface ItemApiService  {
    /**
     * this fun returns a [List] of [Item] and can be called from a coroutine.
     * The @Get annotation indicates that the "hiring.json" endpoint will be requested
     * with Get HTTP method
     */
    @GET("hiring.json")
    fun getData(): Call<List<ItemModel>>
}
