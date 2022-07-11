package com.example.displayitems.model
import com.google.gson.annotations.SerializedName

data class ItemModel(
    @SerializedName("listId")
    val listId: Int,
    @SerializedName("name")
    var name: String?
)




