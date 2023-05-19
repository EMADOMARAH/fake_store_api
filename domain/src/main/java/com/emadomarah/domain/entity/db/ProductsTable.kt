package com.emadomarah.domain.entity.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.emadomarah.domain.entity.product.Rating

@Entity(tableName = "products_table")
data class ProductsTable(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "category") val category: String?,
    @ColumnInfo(name = "description") val description: String?,
    @ColumnInfo(name = "image") val image: String?,
    @ColumnInfo(name = "title") val title: String?,
    @ColumnInfo(name = "price") val price: Double?
)