package com.emadomarah.data.repo

import com.emadomarah.data.local.StoreDao
import com.emadomarah.data.remote.ApiService
import com.emadomarah.domain.entity.db.ProductsTable
import com.emadomarah.domain.entity.db.User

import com.emadomarah.domain.entity.product.ProductResponse
import com.emadomarah.domain.repo.StoreRepo
import javax.inject.Inject


class StoreRepoImpl @Inject constructor(private val apiService: ApiService, private val dao: StoreDao) : StoreRepo{
    override suspend fun getProductFromRemote(): ProductResponse {

        return apiService.getAllProducts()
    }

    override suspend fun getProductFromLocal(): List<ProductsTable> {
       return dao.getAllProducts()
    }

    override suspend fun getUserFromLocal(): List<User> {
        return dao.getAllUsers()
    }

    override suspend fun insertProductToLocal(product: ProductsTable) {
        return dao.insertProduct(product)
    }

    override suspend fun insertUserToLocal(user: User) {
        dao.insertUser(user)
    }

}