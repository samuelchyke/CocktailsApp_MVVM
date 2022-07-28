package com.itc.cocktailapp.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.itc.cocktailapp.cache.CocktailsDAO
import com.itc.cocktailapp.model.CacheCocktails
import javax.inject.Inject

interface CacheCocktailRepository {

    suspend fun insertCocktailsToDatabase(cocktails: List<CacheCocktails>?)

    suspend fun getCocktailsFromDatabase(letter:String) : LiveData<List<CacheCocktails>>

}

class CacheCocktailRepositoryImpl @Inject constructor(
    private val cocktailsDAO: CocktailsDAO
): CacheCocktailRepository{

    override suspend fun insertCocktailsToDatabase(cocktails: List<CacheCocktails>?) {
       return cocktailsDAO.insertCocktails(cocktails)
    }

    override suspend fun getCocktailsFromDatabase(letter: String): LiveData<List<CacheCocktails>> {
        return cocktailsDAO.getCocktails(letter)
    }

}