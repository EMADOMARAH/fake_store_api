package com.emadomarah.domain.repo.usecase

import com.emadomarah.domain.entity.product.ProductResponse
import com.emadomarah.domain.repo.StoreRepo

class StoreUseCases(private val storeRepo: StoreRepo) {

    suspend fun getAllProduct() : ProductResponse {
        return storeRepo.getProductFromRemote()
    }
}