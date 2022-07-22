package com.itc.cocktailapp.api

import com.itc.cocktailapp.model.Cocktails
import com.itc.cocktailapp.util.NetworkResult
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CocktailServiceApi {

    @GET(COCKTAIL_PATH)
    suspend fun getCocktails(
        @Query("f") letter: String
    ): Response<Cocktails>

    companion object{

        const val BASE_URL = "https://www.thecocktaildb.com/"
        private const val COCKTAIL_PATH = "api/json/v1/1/search.php"

    }

}
