package com.example.bosta_task.di

import com.example.bosta_task.data.api.ApiService
import com.example.bosta_task.data.repo.DistrictRepo
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class AppModule {
    @Provides
    fun provideApiService(): ApiService {
        return Retrofit.Builder()
            .baseUrl("https://stg-app.bosta.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    @Provides
    fun provideDistrictRepository(apiService: ApiService): DistrictRepo {
        return DistrictRepo(apiService)
    }
}