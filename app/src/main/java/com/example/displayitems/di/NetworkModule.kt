package com.example.displayitems.di

import com.example.displayitems.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import com.example.displayitems.network.ItemApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@InstallIn(SingletonComponent::class) // dagger install class in singleton component takes it everywhere
@Module
object NetworkModule {
    @Provides
    fun providesApiService() : ItemApiService {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(ItemApiService::class.java)
    }
}