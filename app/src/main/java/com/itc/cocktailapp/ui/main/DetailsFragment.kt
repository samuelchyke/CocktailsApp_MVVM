package com.itc.cocktailapp.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.itc.cocktailapp.databinding.FragmentDetailsBinding
import com.squareup.picasso.Picasso

class DetailsFragment : BaseFragment() {

    private val binding by lazy {
        FragmentDetailsBinding.inflate(layoutInflater)
    }

    private val args by navArgs<DetailsFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        args.currentCocktail

        binding.nameTextVw.text = args.currentCocktail.strDrink
        Picasso.get().load(args.currentCocktail.drinkThumb).fit().into(binding.bannerImgVw)

        return binding.root
    }






}