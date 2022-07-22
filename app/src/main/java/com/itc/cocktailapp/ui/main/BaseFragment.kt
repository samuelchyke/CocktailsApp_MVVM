package com.itc.cocktailapp.ui.main

import android.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.itc.cocktailapp.adapter.CocktailAdapter
import com.itc.cocktailapp.ui.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
open class BaseFragment : Fragment() {

    protected val cocktailViewModel by lazy{
        ViewModelProvider(requireActivity())[MainViewModel::class.java]
    }

    protected val cocktailAdapter by lazy{
        CocktailAdapter()
    }

    protected fun showError(message: String) {
        AlertDialog.Builder(requireContext())
            .setTitle("Error")
            .setMessage(message)
            .setNegativeButton("DISMISS") { dialog, _ ->
                dialog.dismiss()
            }

    }

}