package com.emadomarah.domain.repo.usecase

import com.emadomarah.domain.entity.db.ProductsTable
import com.emadomarah.domain.entity.db.User
import com.emadomarah.domain.entity.product.ProductResponse
import com.emadomarah.domain.repo.StoreRepo

class StoreUseCases(private val storeRepo: StoreRepo) {

    suspend fun getAllProduct() : ProductResponse {
        return storeRepo.getProductFromRemote()
    }

    suspend fun getProductFromLocal() :List<ProductsTable> {
        return storeRepo.getProductFromLocal()
    }

    suspend fun getUserFromLocal():List<User>{
        return storeRepo.getUserFromLocal()
    }
    suspend fun insertProductToLocal(product: ProductsTable){
        return storeRepo.insertProductToLocal(product)
    }
    suspend fun insertUserToLocal(user: User){
        return storeRepo.insertUserToLocal(user)
    }

}