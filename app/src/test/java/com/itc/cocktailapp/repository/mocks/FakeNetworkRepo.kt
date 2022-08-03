package com.itc.cocktailapp.repository.mocks

import com.itc.cocktailapp.model.Cocktails
import com.itc.cocktailapp.repository.CocktailRepository
import com.itc.cocktailapp.util.NetworkResult

class FakeNetworkRepo: CocktailRepository {

    private var networkError = false

    fun returnNetworkError(value: Boolean){
        networkError = value
    }

    override suspend fun getCocktails(letter: String): NetworkResult<Cocktails> {
        return NetworkResult.Success(Cocktails(listOf()))
    }


}