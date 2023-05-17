package com.emadomarah.data.repo

import android.util.Log
import com.emadomarah.data.remote.ApiService
import com.emadomarah.domain.entity.product.ProductResponse
import com.emadomarah.domain.repo.StoreRepo

class StoreRepoImpl(private val apiService: ApiService) : StoreRepo{
    override suspend fun getProductFromRemote(): ProductResponse {

        return apiService.getAllProducts()
    }
}