package com.emadomarah.fake_store_api.di

import com.emadomarah.data.repo.StoreRepoImpl
import com.emadomarah.domain.repo.usecase.StoreUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

// notation for mark this class
// 1. this is a dagger module
// 2. i want this class to be singleton
@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    fun provideUseCase(storeRepoImpl: StoreRepoImpl) : StoreUseCases {
        return StoreUseCases(storeRepoImpl)
    }
}