package com.itc.cocktailapp.ui.main

import android.app.AlertDialog
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.itc.cocktailapp.adapter.CocktailAdapter
import com.itc.cocktailapp.ui.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.internal.Contexts

@AndroidEntryPoint
open class BaseFragment(
) : Fragment() {

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

    //CHECK IF CONNECTED TO INTERNET
    fun hasInternetConnection(): Boolean {
        val connectivityManager = Contexts.getApplication(activity?.applicationContext).getSystemService(
            Context.CONNECTIVITY_SERVICE
        ) as ConnectivityManager
        val activeNetwork = connectivityManager.activeNetwork ?: return false
        val capabilities =
            connectivityManager.getNetworkCapabilities(activeNetwork) ?: return false
        return when {
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
            else -> false
        }
    }

}