package com.emadomarah.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.emadomarah.domain.entity.db.ProductsTable
import com.emadomarah.domain.entity.db.User

@Dao
interface StoreDao {
    @Insert
    fun insertUser(vararg user: User)

    @Insert
    fun insertProduct(vararg product: ProductsTable)

    @Query("SELECT * FROM user_table")
    fun getAllUsers():List<User>

    @Query("SELECT * FROM products_table")
    fun getAllProducts():List<ProductsTable>
}