package com.itc.cocktailapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.itc.cocktailapp.databinding.CocktailsRowViewBinding
import com.itc.cocktailapp.model.CacheCocktails
import com.itc.cocktailapp.model.Cocktails
import com.itc.cocktailapp.model.Drink
import com.itc.cocktailapp.model.mapToCache
import com.itc.cocktailapp.ui.main.CocktailsFragmentDirections
import com.squareup.picasso.Picasso
import okhttp3.internal.notify

class CocktailAdapter : RecyclerView.Adapter<MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder =
        MyViewHolder(
            CocktailsRowViewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val differ = differ.currentList[position]
        holder.bind(differ)

        holder.itemView.setOnClickListener {
            val directionToMainFragment = CocktailsFragmentDirections.actionMainToDetailFragment(differ)
            holder.itemView.findNavController().navigate(directionToMainFragment)
        }
    }

    override fun getItemCount(): Int = differ.currentList.size

    private val differCallback = object : DiffUtil.ItemCallback<CacheCocktails>() {
        override fun areItemsTheSame(oldItem: CacheCocktails, newItem: CacheCocktails): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: CacheCocktails, newItem: CacheCocktails): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)

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

