package com.emadomarah.domain.repo

import com.emadomarah.domain.entity.db.ProductsTable
import com.emadomarah.domain.entity.db.User
import com.emadomarah.domain.entity.product.ProductResponse

interface StoreRepo {
    //fun that get all product list from api
    suspend fun getProductFromRemote() : ProductResponse
    suspend fun getProductFromLocal():List<ProductsTable>
    suspend fun getUserFromLocal():List<User>
    suspend fun insertProductToLocal(product: ProductsTable)
    suspend fun insertUserToLocal(user: User)

}