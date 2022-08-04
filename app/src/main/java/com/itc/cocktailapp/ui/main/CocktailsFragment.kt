package com.itc.cocktailapp.ui.main

import android.os.Bundle
import android.view.*
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.itc.cocktailapp.R
import com.itc.cocktailapp.databinding.FragmentCocktailsBinding
import com.itc.cocktailapp.model.mapToCache
import com.itc.cocktailapp.util.NetworkResult
import kotlinx.coroutines.launch

class CocktailsFragment : BaseFragment() {

    private val binding by lazy {
        FragmentCocktailsBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        initRecyclerView()
        setRecyclerViewUsingDB("")
        return binding.root
    }

    private fun initRecyclerView() {
        //Recycler View
        binding.cocktailRecVw.apply {
            this.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = cocktailAdapter
        }
    }

    private fun observeData(letter: String) {
        cocktailViewModel.cocktails.observe(viewLifecycleOwner) { response ->
            when (response) {
                is NetworkResult.Success -> {
                    cocktailAdapter.differ.submitList(response.data?.drinks?.mapToCache())
                }
                is NetworkResult.Error -> {
                    response.message?.let { message ->
                        showError(message)
                    }
                    setRecyclerViewUsingDB(letter)
                }
                is NetworkResult.Loading -> {
//                    showProgressBar()
                }
                else -> {}
            }
        }
        cocktailViewModel.searchCocktails(letter)
    }

    private fun setRecyclerViewUsingDB(letter: String) = lifecycleScope.launch{
            cocktailViewModel.getCocktailsFromDB(letter).observe(viewLifecycleOwner){
                cocktailAdapter.differ.submitList(it)
            }
        }

    private fun setCocktails(letter: String) {
        if(hasInternetConnection()) {
            observeData(letter)
        }else{
            setRecyclerViewUsingDB(letter)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.nav_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_A -> setCocktails("A")
            R.id.nav_B -> setCocktails("B")
            R.id.nav_C -> setCocktails("C")
            R.id.nav_D -> setCocktails("D")
            R.id.nav_E -> setCocktails("E")
            R.id.nav_F -> setCocktails("F")
            R.id.nav_G -> setCocktails("G")
            R.id.nav_H -> setCocktails("H")
            R.id.nav_I -> setCocktails("I")
            R.id.nav_J -> setCocktails("J")
            R.id.nav_K -> setCocktails("K")
            R.id.nav_L -> setCocktails("L")
            R.id.nav_M -> setCocktails("M")
            R.id.nav_N -> setCocktails("N")
            R.id.nav_O -> setCocktails("O")
            R.id.nav_P -> setCocktails("P")
            R.id.nav_Q -> setCocktails("Q")
            R.id.nav_R -> setCocktails("R")
            R.id.nav_S -> setCocktails("S")
            R.id.nav_T -> setCocktails("T")
            R.id.nav_U -> setCocktails("U")
            R.id.nav_V -> setCocktails("V")
            R.id.nav_W -> setCocktails("W")
            R.id.nav_X -> setCocktails("X")
            R.id.nav_Y -> setCocktails("Y")
            R.id.nav_Z -> setCocktails("Z")
        }
        return super.onOptionsItemSelected(item)
    }

}