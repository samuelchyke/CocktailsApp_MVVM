package com.itc.cocktailapp.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.itc.cocktailapp.model.CacheCocktails

class FakeCacheRepo: CacheCocktailRepository {

    private val _cocktails = mutableListOf<CacheCocktails>()
    private val obsCocktails = MutableLiveData<List<CacheCocktails>>(_cocktails)

    override suspend fun insertCocktailsToDatabase(cocktails: List<CacheCocktails>?) {
        if (cocktails != null) {
            _cocktails.addAll(cocktails)
        }
    }

    override suspend fun getCocktailsFromDatabase(letter: String): LiveData<List<CacheCocktails>> {
        return obsCocktails.apply {_cocktails.find { it.id == letter}}
    }


}