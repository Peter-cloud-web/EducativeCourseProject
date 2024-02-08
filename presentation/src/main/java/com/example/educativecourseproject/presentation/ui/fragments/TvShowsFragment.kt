package com.example.educativecourseproject.presentation.ui.fragments

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import coil.ImageLoader
import com.example.cinemaxv3.util.Constants
import com.example.cinemaxv3.util.Constants.POPULAR_TV_SHOWS
import com.example.cinemaxv3.util.Constants.TOPRATED_TV_SHOWS
import com.example.cinemaxv3.util.Constants.TV_SHOWS_AIRING_TODAY
import com.example.cinemaxv3.util.Constants.TV_SHOWS_ON_THE_AIR
import com.example.cinemaxv3.view.ui.adapter.SharedTvShowsAdapter
import com.example.cinemaxv3.viewmodels.TopRatedTvShowsViewModel.TopRatedTvShowsViewModel
import com.example.cinemaxv3.viewmodels.popularTvShowViewModel.PopularTvShowViewModel
import com.example.cinemaxv3.viewmodels.tvShowsAiringTodayViewModel.TvShowsAiringTodayViewModel
import com.example.cinemaxv3.viewmodels.tvShowsOnTheAirViewModel.TvShowsOnTheAirViewModel
import com.example.educativecourseproject.R
import com.example.educativecourseproject.databinding.FragmentTvShowsBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class TvShowsFragment : Fragment(R.layout.fragment_tv_shows) {

    private lateinit var sharedTvShowsAdapter: SharedTvShowsAdapter

    private val topRatedTvShowsViewModel: TopRatedTvShowsViewModel by viewModels()
    private val popularTvShowViewModel: PopularTvShowViewModel by viewModels()
    private val tvShowsAiringTodayViewModel: TvShowsAiringTodayViewModel by viewModels()
    private val tvShowsOnTheAirViewModel: TvShowsOnTheAirViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentTvShowsBinding.bind(view)
        val imageLoader = ImageLoader(requireContext())
        setHasOptionsMenu(true)



        initilizations(imageLoader)
        loadViewToRecyclerViews(binding)
        loadDefaultTvShowsBeforeOptions()
        tvShowsInDetail()
        setupMenu()
    }

    private fun initilizations(imageLoader: ImageLoader) {
        sharedTvShowsAdapter = SharedTvShowsAdapter(imageLoader = imageLoader)
    }

    private fun loadViewToRecyclerViews(binding: FragmentTvShowsBinding) {
        binding.topRatedTvShowsMoviesRecyclerview.apply {
            layoutManager = GridLayoutManager(activity, 3)
            adapter = sharedTvShowsAdapter
        }
    }

    private fun loadDefaultTvShowsBeforeOptions() {

        topRatedTvShowsViewModel.topRatedTvShowsUiState.observe(viewLifecycleOwner,
            Observer { uiState ->
                when {
                    uiState.isLoading -> {}
                    uiState.movies != null -> {
                        uiState.movies.observe(viewLifecycleOwner, Observer { topRatedTVshows ->
                            lifecycleScope.launch {
                                sharedTvShowsAdapter.submitData(topRatedTVshows)
                            }
                        })
                    }

                    uiState.error != null -> {
                        Toast.makeText(
                            requireContext(),
                            "An unexpected error occurred",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            })
    }


    private fun tvShowsInDetail() {
        sharedTvShowsAdapter.setOnClickListener { tvShowResults ->

            tvShowResults.apply {
                val movieId = id
                val backdrop = Constants.IMAGE_BASE_URL + backdrop_path
                val description = overview
                val title = name
                val image = Constants.IMAGE_BASE_URL + poster_path
                val rating = vote_average

                val action = TvShowsFragmentDirections.actionTvShowsFragmentToMovieDetailsFragment(
                    image,
                    backdrop,
                    title,
                    description,
                    rating.toFloat(),
                    movieId
                )
                findNavController().navigate(action)
            }
        }
    }

    private fun setupMenu() {
        (requireActivity() as MenuHost).addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.tvshows_menu, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {

                val actionbar = (activity as AppCompatActivity).supportActionBar


                when (menuItem.itemId) {

                    R.id.topRatedTvShows -> {

                        actionbar?.apply {
                            setDisplayHomeAsUpEnabled(true)
                            setBackgroundDrawable(context?.let {
                                ContextCompat.getColor(
                                    it,
                                    R.color.black
                                )
                            }?.let { ColorDrawable(it) })
                            title = TOPRATED_TV_SHOWS
                        }

                        topRatedTvShowsViewModel.topRatedTvShowsUiState.observe(
                            viewLifecycleOwner,
                            Observer { uiState ->
                                when {
                                    uiState.isLoading -> {
                                        Toast.makeText(
                                            requireContext(),
                                            "We are loading..",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    }

                                    uiState.movies != null -> {
                                        uiState.movies.observe(
                                            viewLifecycleOwner,
                                            Observer { topRatedTVShows ->
                                                lifecycleScope.launch {
                                                    sharedTvShowsAdapter.submitData(topRatedTVShows)
                                                }
                                            })
                                    }

                                    uiState.error != null -> {
                                        Toast.makeText(
                                            requireContext(),
                                            "An unexpected error occurred",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    }
                                }
                            })
                        return true
                    }

                    R.id.popularTvShows -> {

                        actionbar?.apply {
                            setDisplayHomeAsUpEnabled(true)
                            title = POPULAR_TV_SHOWS
                        }

                        popularTvShowViewModel.popularTvShowsUiStates.observe(
                            viewLifecycleOwner,
                            Observer { uiState ->
                                when {
                                    uiState.isLoading -> {}
                                    uiState.movies != null -> {
                                        uiState.movies.observe(
                                            viewLifecycleOwner,
                                            Observer { popularTvShows ->
                                                lifecycleScope.launch {
                                                    sharedTvShowsAdapter.submitData(popularTvShows)
                                                }
                                            })
                                    }

                                    uiState.error != null -> {
                                        Toast.makeText(
                                            requireContext(),
                                            "An unexpected error occurred",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    }

                                    else -> {}
                                }
                            })
                        return true

                    }

                    R.id.tvShowsOnTheAir -> {

                        actionbar?.apply {
                            setDisplayHomeAsUpEnabled(true)
                            title =  TV_SHOWS_ON_THE_AIR
                        }
                        tvShowsOnTheAirViewModel.tvShowsOnTheAir.observe(
                            viewLifecycleOwner,
                            Observer { uiState ->
                                when {
                                    uiState.isLoading -> {}
                                    uiState.movies != null -> {
                                        uiState.movies.observe(
                                            viewLifecycleOwner,
                                            Observer { tvShowsOnTheAirData ->
                                                lifecycleScope.launch {
                                                    sharedTvShowsAdapter.submitData(
                                                        tvShowsOnTheAirData
                                                    )
                                                }
                                            })
                                    }

                                    uiState.error != null -> {
                                        Toast.makeText(
                                            requireContext(),
                                            "An unexpected error occurred",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    }
                                }
                            })

                        return true
                    }

                    R.id.tvShowsAiringToday -> {

                        actionbar?.apply {
                            setDisplayHomeAsUpEnabled(true)
                            title = TV_SHOWS_AIRING_TODAY
                        }

                        tvShowsAiringTodayViewModel.tvShowsAiringTodayUiState.observe(
                            viewLifecycleOwner,
                            Observer { uiState ->
                                when {
                                    uiState.isLoading -> {}
                                    uiState.movies != null -> {
                                        uiState.movies.observe(
                                            viewLifecycleOwner,
                                            Observer { tvShowsAiringTodayData ->
                                                lifecycleScope.launch {
                                                    sharedTvShowsAdapter.submitData(
                                                        tvShowsAiringTodayData
                                                    )
                                                }
                                            })
                                    }

                                    uiState.error != null -> {
                                        Toast.makeText(
                                            requireContext(),
                                            "An unexpected error occurred",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    }
                                }
                            })
                        return true
                    }

                    android.R.id.home -> {
                        // Handle up button click
                        requireActivity().onBackPressed()
                    }
                }
                return true
            }
        })
    }
}

