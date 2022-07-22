package com.itc.cocktailapp.di

import com.itc.cocktailapp.model.CacheCocktails
import com.itc.cocktailapp.repository.CacheCocktailRepository
import com.itc.cocktailapp.repository.CacheCocktailRepositoryImpl
import com.itc.cocktailapp.repository.CocktailRepository
import com.itc.cocktailapp.repository.CocktailRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent


@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideRepository( cocktailRepositoryImpl: CocktailRepositoryImpl): CocktailRepository
    @Binds
    abstract fun provideCacheRepository( cacheRepositoryImpl: CacheCocktailRepositoryImpl): CacheCocktailRepository


}