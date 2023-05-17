package com.emadomarah.fake_store_api.di

import com.emadomarah.data.remote.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

// notation for mark this class
// 1. this is a dagger module
// 2. i want this class to be singleton
@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    //to tell hilt if you want a okHttpClient take this we add provides notation
    @Provides
    @Singleton
    fun provideOkHttp(): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(20, TimeUnit.SECONDS)
            .readTimeout(20, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient):Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://fakestoreapi.com/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideApiServices(retrofit: Retrofit):ApiService{
        return retrofit.create(ApiService::class.java)
    }

}