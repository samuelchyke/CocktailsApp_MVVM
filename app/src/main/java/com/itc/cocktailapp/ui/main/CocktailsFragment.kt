package com.itc.cocktailapp.ui.main

import android.os.Bundle
import android.view.*
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.itc.cocktailapp.R
import com.itc.cocktailapp.databinding.FragmentCocktailsBinding
import com.itc.cocktailapp.util.NetworkResult
import kotlinx.coroutines.launch

class CocktailsFragment : BaseFragment() {


    private val binding by lazy {
        FragmentCocktailsBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        hasOptionsMenu()
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.nav_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {

            R.id.nav_A -> switchCocktails("A")
            R.id.nav_B -> switchCocktails("B")
            R.id.nav_C -> switchCocktails("C")
            R.id.nav_D -> switchCocktails("D")
            R.id.nav_E -> switchCocktails("E")
            R.id.nav_F -> switchCocktails("F")
            R.id.nav_G -> switchCocktails("G")
            R.id.nav_H -> switchCocktails("H")
            R.id.nav_I -> switchCocktails("I")
            R.id.nav_J -> switchCocktails("J")
            R.id.nav_K -> switchCocktails("K")
            R.id.nav_L -> switchCocktails("L")
            R.id.nav_M -> switchCocktails("M")
            R.id.nav_N -> switchCocktails("N")
            R.id.nav_O -> switchCocktails("O")
            R.id.nav_P -> switchCocktails("P")
            R.id.nav_Q -> switchCocktails("Q")
            R.id.nav_R -> switchCocktails("R")
            R.id.nav_S -> switchCocktails("S")
            R.id.nav_T -> switchCocktails("T")
            R.id.nav_U -> switchCocktails("U")
            R.id.nav_V -> switchCocktails("V")
            R.id.nav_W -> switchCocktails("W")
            R.id.nav_X -> switchCocktails("X")
            R.id.nav_Y -> switchCocktails("Y")
            R.id.nav_Z -> switchCocktails("Z")

        }

        return super.onOptionsItemSelected(item)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        initRecyclerView()
        switchCocktails("")
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
                is NetworkResult.Success<*> -> {
                    response.data?.let {
                        it.drinks?.let { drinks -> cocktailAdapter.setCocktails2(drinks) }
                    }
                }
                is NetworkResult.Error -> {
                    response.message?.let { message ->
                        showError(message)
                    }
                }
                is NetworkResult.Loading -> {
//                    showProgressBar()
                }
                else -> {}
            }
        }
        cocktailViewModel.searchCocktails(letter)
    }

    private fun setRecyclerView(letter: String) {
        lifecycleScope.launch {
            cocktailAdapter.setCocktails(cocktailViewModel.getCocktailsFromDB(letter))
        }
    }

    private fun switchCocktails(letter: String) {
        observeData(letter)
        setRecyclerView(letter)
    }

}