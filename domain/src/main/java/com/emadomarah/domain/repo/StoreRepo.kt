package com.emadomarah.domain.repo

import com.emadomarah.domain.entity.product.ProductResponse

interface StoreRepo {
    //fun that get all product list from api
    fun getProductFromRemote() : ProductResponse
}