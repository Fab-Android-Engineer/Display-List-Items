package com.example.displayitems.viewmodel
import android.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.displayitems.model.ItemModel
import com.example.displayitems.network.ItemApiService
import kotlinx.coroutines.channels.ChannelResult.Companion.success
import kotlinx.coroutines.runBlocking
import okhttp3.Response
import org.junit.Assert

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import retrofit2.Response.success
import kotlin.Result.Companion.success

@RunWith(AndroidJUnit4::class)
class ItemViewModelTest {

   @get:Rule
   val instantTaskExecutionRule = InstantTaskExecutorRule()

   lateinit var itemViewModel: ItemViewModel
   private val itemApiService = mock<ItemApiService>()


   @Before
   fun setup() {
      itemViewModel = ItemViewModel(itemApiService)
   }

//   @Test
//   fun `Loading state works`() = runBlocking {
//      whenever(itemApiService.getData()).thenReturn(Response.success(listOf<ItemModel>()))
//      itemViewModel = ItemViewModel(itemApiService)
//      Assert.assertEquals(List<ItemModel>(ItemModel(5, "Item 110")))
//   }
}