package com.emadomarah.fake_store_api.ui.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.emadomarah.domain.entity.product.ProductModel
import com.emadomarah.domain.entity.product.ProductResponse
import com.emadomarah.domain.repo.usecase.StoreUseCases
import com.emadomarah.fake_store_api.R
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class StoreViewModel @Inject constructor(
    private val getStoreUseCases: StoreUseCases
) : ViewModel() {

    private val _products : MutableStateFlow<ProductResponse?> = MutableStateFlow(null)
    val products : StateFlow<ProductResponse?> = _products
    val productCategoriesList:MutableList<String> = ArrayList()




    fun getProducts(){
        viewModelScope.launch {
            try {
                _products.value = getStoreUseCases.getAllProduct()

                Log.d("ViewModelData" , products.value.toString())

            }catch (e:Exception){
                Log.e("StoreViewModel" , e.message.toString())
            }

        }

    }
}