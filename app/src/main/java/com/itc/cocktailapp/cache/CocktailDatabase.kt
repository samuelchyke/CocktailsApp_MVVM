package com.itc.cocktailapp.cache

import androidx.room.Database
import androidx.room.RoomDatabase
import com.itc.cocktailapp.model.CacheCocktails

@Database(entities = [CacheCocktails::class], version = 1, exportSchema = false )
abstract class CocktailDatabase : RoomDatabase() {

    abstract fun cocktailsDAO(): CocktailsDAO

}