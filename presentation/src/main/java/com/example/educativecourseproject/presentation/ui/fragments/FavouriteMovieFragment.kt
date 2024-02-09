package com.example.educativecourseproject.presentation.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import coil.ImageLoader
import com.example.cinemaxv3.util.Constants
import com.example.cinemaxv3.view.ui.adapter.FavouriteMoviesAdapter
import com.example.cinemaxv3.viewmodels.favouriteMoviesViewModel.FavouriteMoviesViewModel
import com.example.domain.entities.model.favourites.FavouriteMovies
import com.example.educativecourseproject.R
import com.example.educativecourseproject.databinding.FragmentFavouriteMovieBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
@AndroidEntryPoint
class FavouriteMovieFragment : Fragment(R.layout.fragment_favourite_movie) {
    private lateinit var favouriteMoviesAdapter: FavouriteMoviesAdapter
    private val favouriteMoviesViewModel: FavouriteMoviesViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentFavouriteMovieBinding.bind(view)

        val imageLoader = ImageLoader(requireContext())
        favouriteMoviesAdapter = FavouriteMoviesAdapter(imageLoader)

        populateRecyclerView(binding)
        handleItemOnClick()
        deleteFavouriteMovie()
    }

    private fun handleItemOnClick() {
        favouriteMoviesAdapter.setOnItemClickListener { favouriteMovies ->
            navigateToDetailsScreen(favouriteMovies)
        }
    }

    private fun navigateToDetailsScreen(favouriteMovies: FavouriteMovies) {
        with(favouriteMovies) {
            val action =
                FavouriteMovieFragmentDirections.actionFavouriteMovieFragment2ToMovieDetailsFragment(
                    Constants.IMAGE_BASE_URL + poster_path!!,
                    Constants.IMAGE_BASE_URL + backdrop_path!!,
                    title!!.toString(),
                    overview!!.toString(),
                    vote_average!!.toFloat(),
                    id!!
                )
            findNavController().navigate(action)
        }
    }

    private fun deleteFavouriteMovie() {
        favouriteMoviesAdapter.setOnDeleteMovieClickListener { id ->
            favouriteMoviesViewModel.deleteFavouriteMovie(id)
        }
    }

    private fun populateRecyclerView(binding: FragmentFavouriteMovieBinding) {
        viewLifecycleOwner.lifecycleScope.launch {
            favouriteMoviesViewModel.favouriteMovies.collectLatest { uiStates ->

                with(uiStates) {

                    when {
                        isLoading -> {}

                        favouriteMovies != null -> {
                            uiStates.favouriteMovies.collect { favouriteMoviesList ->
                                favouriteMoviesAdapter.favouriteMovies.submitList(
                                    favouriteMoviesList
                                )
                            }
                        }

                        error != null -> {
                            Toast.makeText(
                                requireContext(),
                                "An unexpected error occurred",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                }
            }
        }

        binding.favRecyclerView.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = favouriteMoviesAdapter
        }

    }
}