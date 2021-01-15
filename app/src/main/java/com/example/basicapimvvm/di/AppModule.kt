package com.example.basicapimvvm.di

import com.example.basicapimvvm.data.api.NewsAPIService
import com.example.basicapimvvm.repository.MainRepository
import com.example.basicapimvvm.utils.Constant
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideNewsAPIService(): NewsAPIService = Retrofit.Builder().
    addConverterFactory(GsonConverterFactory.create())
        .baseUrl(Constant.BASE_URL).build()
            .create(NewsAPIService::class.java)

    @Singleton
    @Provides
    fun provideMainRepository(newsAPIService: NewsAPIService) = MainRepository(newsAPIService)

}