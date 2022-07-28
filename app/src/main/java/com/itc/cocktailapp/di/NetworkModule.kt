package com.itc.cocktailapp.di

import com.google.gson.Gson
import com.itc.cocktailapp.api.CocktailServiceApi
import com.itc.cocktailapp.api.CocktailServiceApi.Companion.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    // CONVERT NETWORK RESPONSE T0 GSON KOTLIN OBJECT
    @Provides
    fun provideGson(): Gson = Gson()

    // LOGS RETROFIT REQUESTS & RESPONSES
    @Provides
    fun loggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

    // NETWORK CLIENT PERFORMS CACHING, REQUESTS & RESPONSES
    @Provides
    fun provideOkHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build()

    // CREATES A SINGLETON RETROFIT INSTANCE
    @Provides
    fun providesRetrofit(okHttpClient : OkHttpClient, gson: Gson): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(okHttpClient)
            .build()

    // PROVIDES RETROFIT INSTANCE
    @Provides
    fun provideCocktailService(retrofit : Retrofit) : CocktailServiceApi =
        retrofit.create(CocktailServiceApi::class.java)

}