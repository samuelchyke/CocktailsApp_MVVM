package com.itc.cocktailapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.itc.cocktailapp.databinding.CocktailsRowViewBinding
import com.itc.cocktailapp.model.CacheCocktails
import com.itc.cocktailapp.model.Cocktails
import com.itc.cocktailapp.model.Drink
import com.itc.cocktailapp.model.mapToCache
import com.itc.cocktailapp.ui.main.CocktailsFragmentDirections
import com.squareup.picasso.Picasso
import okhttp3.internal.notify

class CocktailAdapter(
    private var mCocktailsList: MutableList<CacheCocktails> = mutableListOf(),
    private var mCList: List<Drink> = mutableListOf()
) : RecyclerView.Adapter<MyViewHolder>(
) {

    fun setCocktails(cocktails: MutableList<CacheCocktails>) {
        mCocktailsList.clear()
        this.mCocktailsList = cocktails
        notifyDataSetChanged()
    }

    fun setCocktails2(cocktails: List<Drink>) {
        mCocktailsList.clear()
        this.mCocktailsList = cocktails.mapToCache() as MutableList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder =
        MyViewHolder(
            CocktailsRowViewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val c = mCocktailsList[position]
        holder.bind(c)
        holder.itemView.setOnClickListener {
            val directionToMainFragment = CocktailsFragmentDirections.actionMainToDetailFragment(c)
            holder.itemView.findNavController().navigate(directionToMainFragment)
        }
    }

    override fun getItemCount(): Int = mCocktailsList.size

}

class MyViewHolder(
    private val binding: CocktailsRowViewBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(cocktails: CacheCocktails) {
        binding.nameTxtVw.text = cocktails.strDrink
        Picasso.get()
            .load(cocktails.drinkThumb)
            .fit()
            .into(binding.imgVW)

    }
}