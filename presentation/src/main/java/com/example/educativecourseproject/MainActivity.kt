package com.example.educativecourseproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.educativecourseproject.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        setUpNavigation()
    }

    private fun setUpNavigation(){
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.movieNavHostFragment) as NavHostFragment
        val navController = navHostFragment.navController
        mainBinding.bottomNavigationView.setupWithNavController(navController)
    }
}