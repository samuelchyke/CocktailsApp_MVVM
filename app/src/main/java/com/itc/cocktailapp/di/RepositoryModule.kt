package com.itc.cocktailapp.di

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import com.itc.cocktailapp.repository.CacheCocktailRepository
import com.itc.cocktailapp.repository.CacheCocktailRepositoryImpl
import com.itc.cocktailapp.repository.CocktailRepository
import com.itc.cocktailapp.repository.CocktailRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.internal.Contexts
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ViewModelScoped
import java.security.AccessController.getContext


@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {

    @Binds
    @ViewModelScoped
    abstract fun provideRepository( cocktailRepositoryImpl: CocktailRepositoryImpl): CocktailRepository

    @Binds
    @ViewModelScoped
    abstract fun provideCacheRepository( cacheRepositoryImpl: CacheCocktailRepositoryImpl): CacheCocktailRepository

}