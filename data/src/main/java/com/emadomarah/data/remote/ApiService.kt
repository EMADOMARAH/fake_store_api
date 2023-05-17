package com.emadomarah.data.remote

import com.emadomarah.domain.entity.product.ProductResponse
import retrofit2.http.GET

interface ApiService {

    @GET("products")
    suspend fun getAllProducts() : ProductResponse
}