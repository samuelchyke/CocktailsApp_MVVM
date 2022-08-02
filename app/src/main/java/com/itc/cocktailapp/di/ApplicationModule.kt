package com.itc.cocktailapp.di

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import androidx.room.Room
import com.itc.cocktailapp.cache.CocktailDatabase
import com.itc.cocktailapp.cache.CocktailsDAO
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.internal.Contexts
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApplicationModule {

    @Provides
    @Singleton
    fun providesRoomDb(@ApplicationContext appContext:Context): CocktailDatabase = Room.databaseBuilder(
        appContext,
        CocktailDatabase::class.java,
        "cocktail-db"
    ).
    build()

    @Provides
    @Singleton
    fun providesCocktailDAO(database:CocktailDatabase): CocktailsDAO =
        database.cocktailsDAO()
}