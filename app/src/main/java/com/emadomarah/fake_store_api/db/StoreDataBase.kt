package com.emadomarah.fake_store_api.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.emadomarah.data.local.StoreDao

import com.emadomarah.domain.entity.db.ProductsTable
import com.emadomarah.domain.entity.db.User
import dagger.Binds
import dagger.Provides
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton


@Database(entities = [User::class , ProductsTable::class] , version = 2, exportSchema = false)
abstract class StoreDataBase : RoomDatabase(){
    abstract fun storeDao():StoreDao

}