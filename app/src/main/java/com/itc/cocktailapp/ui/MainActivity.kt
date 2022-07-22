package com.itc.cocktailapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.itc.cocktailapp.R
import com.itc.cocktailapp.databinding.ActivityMainBinding
import com.itc.cocktailapp.ui.main.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    var cat : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        setUpActionBarNavController()

    }

    private fun setUpActionBarNavController() {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.cocktailsFragment,
                R.id.detailsFragment

            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
//
//    override fun onCreateOptionsMenu(menu: Menu): Boolean {
//        menuInflater.inflate(R.menu.nav_menu, menu)
//        return super.onCreateOptionsMenu(menu)
//    }


//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        when (item.itemId){
//
//            R.id.nav_A -> cat = "A"
//            R.id.nav_B -> cat = holder("b")
//            R.id.nav_C -> cat = "C"
//            R.id.nav_D -> cat = "D"
//            R.id.nav_E -> cat = "E"
//            R.id.nav_F -> cat = "F"
//            R.id.nav_G -> cat = "G"
//            R.id.nav_H -> cat = "H"
//            R.id.nav_I -> cat = "I"
//            R.id.nav_J -> cat = "J"
//            R.id.nav_K -> cat = "K"
//            R.id.nav_L -> cat = "L"
//            R.id.nav_M -> cat = "M"
//            R.id.nav_N -> cat = "N"
//            R.id.nav_O -> cat = "O"
//            R.id.nav_P -> cat = "P"
//            R.id.nav_Q -> cat = "Q"
//            R.id.nav_R -> cat = "R"
//            R.id.nav_S -> cat = "S"
//            R.id.nav_T -> cat = "T"
//            R.id.nav_U -> cat = "U"
//            R.id.nav_V -> cat = "V"
//            R.id.nav_W -> cat = "W"
//            R.id.nav_X -> cat = "X"
//            R.id.nav_Y -> cat = "Y"
//            R.id.nav_Z -> cat = "Z"
//
//        }
//
//        return super.onOptionsItemSelected(item)
//    }

    private fun holder(s:String): String {
        val fragment = BaseFragment()
        val bundle = Bundle()
        bundle.putString("string", s)
        fragment.arguments = bundle
        return s
    }
}