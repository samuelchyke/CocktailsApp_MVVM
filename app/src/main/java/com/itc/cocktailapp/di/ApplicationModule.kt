package com.itc.cocktailapp.di

import android.app.Application;
import android.content.Context;
import androidx.room.Room

import com.itc.cocktailapp.cache.CocktailDatabase;
import com.itc.cocktailapp.cache.CocktailsDAO
import com.itc.cocktailapp.model.Cocktails;
import dagger.Module

import dagger.Provides;
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApplicationModule {

    @Provides
    fun providesRoomDb(@ApplicationContext appContext:Context): CocktailDatabase = Room.databaseBuilder(
        appContext,
        CocktailDatabase::class.java,
        "cocktail-db"
    ).
    build()

    @Provides
    fun providesCocktailDAO(database:CocktailDatabase): CocktailsDAO =
        database.cocktailsDAO()

}