package com.emadomarah.domain.usecase

import com.emadomarah.domain.repo.StoreRepo

class StoreUseCases(private val storeRepo: StoreRepo) {

    suspend fun getAllProduct() {
        storeRepo.getProductFromRemote()
    }
}