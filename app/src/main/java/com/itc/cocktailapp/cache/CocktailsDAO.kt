package com.itc.cocktailapp.cache

import androidx.lifecycle.LiveData
import androidx.room.*
import com.itc.cocktailapp.model.CacheCocktails

@Dao
interface CocktailsDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertCocktails(cocktails: List<CacheCocktails>?)

    @Query("SELECT * FROM cocktails_table WHERE strDrink LIKE  :letter || '%' ")
    fun getCocktails(letter: String): LiveData<List<CacheCocktails>>

    // Testing

    @Insert
    fun insertTestCocktail(cocktails: CacheCocktails)

    @Query("SELECT * FROM cocktails_table ORDER BY strDrink ASC ")
    fun getTestCocktail(): CacheCocktails
}