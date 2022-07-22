package com.itc.cocktailapp.repository

import com.itc.cocktailapp.api.CocktailServiceApi
import com.itc.cocktailapp.model.Cocktails
import com.itc.cocktailapp.util.NetworkResult
import retrofit2.Response
import javax.inject.Inject

interface CocktailRepository {
   suspend fun getCocktails(letter:String): Response<Cocktails>
}

class CocktailRepositoryImpl @Inject constructor (
   private val cocktailsServiceApi: CocktailServiceApi
) : CocktailRepository{

   override suspend fun getCocktails(letter:String): Response<Cocktails> {
      return cocktailsServiceApi.getCocktails(letter)
   }

}