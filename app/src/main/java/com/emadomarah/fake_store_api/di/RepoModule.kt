package com.emadomarah.fake_store_api.di

import android.content.Context
import androidx.room.Room
import com.emadomarah.data.local.StoreDao
import com.emadomarah.data.remote.ApiService
import com.emadomarah.data.repo.StoreRepoImpl
import com.emadomarah.domain.repo.StoreRepo
import com.emadomarah.fake_store_api.db.StoreDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

// notation for mark this class
// 1. this is a dagger module
// 2. i want this class to be singleton
@Module
@InstallIn(SingletonComponent::class)
object RepoModule {

    @Singleton
    @Provides
    fun provideStoreDatabaseInstance(
        @ApplicationContext app: Context
    ): StoreDataBase {
        return Room.databaseBuilder(
            app,
            StoreDataBase::class.java,
            "store_db"
        ).allowMainThreadQueries().build()
    }
    @Singleton
    @Provides
    fun provideStoreDao(database: StoreDataBase): StoreDao {
        return database.storeDao()
    }

    @Singleton
    @Provides
    fun provideRepo(apiService: ApiService, dao: StoreDao): StoreRepo {
        return StoreRepoImpl(apiService, dao)
    }

}