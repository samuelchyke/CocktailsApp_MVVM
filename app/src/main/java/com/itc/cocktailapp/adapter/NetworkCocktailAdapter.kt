//package com.itc.cocktailapp.adapter
//
//import android.view.LayoutInflater
//import android.view.ViewGroup
//import androidx.navigation.findNavController
//import androidx.recyclerview.widget.RecyclerView
//import com.itc.cocktailapp.databinding.CocktailsRowViewBinding
//import com.itc.cocktailapp.databinding.DrinkRowViewBinding
//import com.itc.cocktailapp.model.CacheCocktails
//import com.itc.cocktailapp.model.Cocktails
//import com.itc.cocktailapp.model.Drink
//import com.itc.cocktailapp.ui.main.CocktailsFragmentDirections
//import com.squareup.picasso.Picasso
//import okhttp3.internal.notify
//
//class Cocktail2Adapter(
//    private var mCList: MutableList<Drink> = mutableListOf()
//) : RecyclerView.Adapter<MyViewHolder>(
//) {
//
//
//    fun setCocktails2(cocktails: MutableList<Drink>) {
//        mCList.clear()
//        this.mCList = cocktails
//        notifyDataSetChanged()
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder2 =
//        MyViewHolder2(
//            CocktailsRowViewBinding.inflate(
//                LayoutInflater.from(parent.context),
//                parent,
//                false
//            )
//        )
//
//
//    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
//        val c = mCList[position]
//        holder.bind(c)
//        holder.itemView.setOnClickListener {
//            val directionToMainFragment = CocktailsFragmentDirections.actionMainToDetailFragment(c)
//            holder.itemView.findNavController().navigate(directionToMainFragment)
//        }
//    }
//
//    override fun getItemCount(): Int = mCList.size
//
//}
//
//class MyViewHolder2(
//    private val binding: CocktailsRowViewBinding
//) : RecyclerView.ViewHolder(binding.root) {
//
//    fun bind(cocktails: Drink) {
//        binding.nameTxtVw.text = cocktails.strDrink
//        Picasso.get()
//            .load(cocktails.strDrinkThumb)
//            .fit()
//            .into(binding.imgVW)
//
//    }
//}