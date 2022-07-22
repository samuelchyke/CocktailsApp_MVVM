package com.itc.cocktailapp.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "cocktails_table")
data class CacheCocktails(
    @PrimaryKey
    val id: String,
    val strAlcoholic: String,
    val strCategory: String,
    val strDrink: String,
    val drinkThumb: String,
    val strIngredient1: String,
    val strIngredient2: String,
    val strIngredient3: String,
    val strIngredient4: String,
    val strIngredient5: String,
    val strIngredient6: String,
    val strIngredient7: String,
    val strIngredient8: String,
    val strIngredient9: String,
    val strIngredient10: String,
    val strIngredient11: String,
    val strIngredient12: String,
    val strIngredient13: String,
    val strIngredient14: String,
    val strIngredient15: String,
    val strInstructions: String,
    ): Parcelable

fun List<Drink>.mapToCache(): List<CacheCocktails> {
    return this.map { cocktails ->
        CacheCocktails(
            id = cocktails.idDrink?:"",
            strAlcoholic = cocktails.strAlcoholic?:"",
            strCategory = cocktails.strCategory?:"",
            strDrink = cocktails.strDrink?:"",
            drinkThumb = cocktails.strDrinkThumb?:"",
            strIngredient1 = cocktails.strIngredient1?:"",
            strIngredient2 = cocktails.strIngredient2?:"",
            strIngredient3 = cocktails.strIngredient3?:"",
            strIngredient4 = cocktails.strIngredient4?:"",
            strIngredient5 = cocktails.strIngredient5?:"",
            strIngredient6 = cocktails.strIngredient6?:"",
            strIngredient7 = cocktails.strIngredient7?:"",
            strIngredient8 = cocktails.strIngredient8?:"",
            strIngredient9 = cocktails.strIngredient9?:"",
            strIngredient10 = cocktails.strIngredient10?:"",
            strIngredient11 = cocktails.strIngredient11?:"",
            strIngredient12 = cocktails.strIngredient12?:"",
            strIngredient13 = cocktails.strIngredient13?:"",
            strIngredient14 = cocktails.strIngredient14?:"",
            strIngredient15 = cocktails.strIngredient15?:"",
            strInstructions = cocktails.strInstructions?:"",
        )
    }

}

fun List<Drink>.mapToCacheC(): List<CacheCocktails> {
    return this.map { cocktails ->
        CacheCocktails(
            id = cocktails.idDrink?:"",
            strAlcoholic = cocktails.strAlcoholic?:"",
            strCategory = cocktails.strCategory?:"",
            strDrink = cocktails.strDrink?:"",
            drinkThumb = cocktails.strDrinkThumb?:"",
            strIngredient1 = cocktails.strIngredient1?:"",
            strIngredient2 = cocktails.strIngredient2?:"",
            strIngredient3 = cocktails.strIngredient3?:"",
            strIngredient4 = cocktails.strIngredient4?:"",
            strIngredient5 = cocktails.strIngredient5?:"",
            strIngredient6 = cocktails.strIngredient6?:"",
            strIngredient7 = cocktails.strIngredient7?:"",
            strIngredient8 = cocktails.strIngredient8?:"",
            strIngredient9 = cocktails.strIngredient9?:"",
            strIngredient10 = cocktails.strIngredient10?:"",
            strIngredient11 = cocktails.strIngredient11?:"",
            strIngredient12 = cocktails.strIngredient12?:"",
            strIngredient13 = cocktails.strIngredient13?:"",
            strIngredient14 = cocktails.strIngredient14?:"",
            strIngredient15 = cocktails.strIngredient15?:"",
            strInstructions = cocktails.strInstructions?:"",
        )
    }

}