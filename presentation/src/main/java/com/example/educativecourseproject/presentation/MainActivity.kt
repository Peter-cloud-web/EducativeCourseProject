package com.example.educativecourseproject.presentation

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.cinemaxv3.receivers.ConnectivityObserver
import com.example.cinemaxv3.receivers.ConnectivityObserverImpl
import com.example.educativecourseproject.R
import com.example.educativecourseproject.databinding.ActivityMainBinding
import com.example.educativecourseproject.databinding.InternetConnectionDialogueBinding
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding
    private lateinit var internetPopup: InternetConnectionDialogueBinding
    private lateinit var status: String
    private lateinit var connectivityObserver: ConnectivityObserver
    private lateinit var connectivityDialog: Dialog

    private val networkConnectivityObserver: ConnectivityObserverImpl by lazy {
        ConnectivityObserverImpl(this)
    }

    private var isDialogShown = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        internetPopup = InternetConnectionDialogueBinding.inflate(layoutInflater)

        connectivityDialog = Dialog(this)
        connectivityDialog.setContentView(R.layout.internet_connection_dialogue)
        connectivityDialog.window?.setGravity(Gravity.CENTER)

        observeConnectivityChanges()
        setUpNavigation()

        internetPopup.buttonRetry.setOnClickListener {
            hideDialog()
            Log.d("MAIN ACTIVITY","Retry button clicked")
        }

    }

    private fun observeConnectivityChanges() {
        lifecycleScope.launch {
            networkConnectivityObserver.observer().collect { status ->
                when (status) {
                    ConnectivityObserver.Status.UnAvailable -> showDialog()
                    ConnectivityObserver.Status.Available -> hideDialog()
                }
            }
        }
    }

    private fun showDialog() {
        if (!isDialogShown) {
            connectivityDialog.show()
            isDialogShown = true
        }
    }

    private fun hideDialog() {
        if (isDialogShown) {
            connectivityDialog.dismiss()
            isDialogShown = false
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(networkConnectivityObserver.networkChangeReceiver)
    }

    private fun setUpNavigation() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.movieNavHostFragment) as NavHostFragment
        val navController = navHostFragment.navController
        mainBinding.bottomNavigationView.setupWithNavController(navController)
    }
}