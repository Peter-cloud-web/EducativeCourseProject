package com.example.educativecourseproject.presentation.ui.fragments

import android.annotation.SuppressLint
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import androidx.navigation.fragment.navArgs
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavArgs
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import coil.ImageLoader
import com.bumptech.glide.Glide
import com.example.cinemaxv3.receivers.ConnectivityObserver
import com.example.cinemaxv3.receivers.ConnectivityObserverImpl
import com.example.cinemaxv3.util.Constants
import com.example.cinemaxv3.util.Constants.IMAGE_BASE_URL
import com.example.cinemaxv3.view.ui.adapter.PopularMovieAdapter
import com.example.cinemaxv3.view.ui.adapter.TopRatedMoviesAdapter
import com.example.cinemaxv3.view.ui.adapter.UpComingMoviesAdapter
import com.example.cinemaxv3.viewmodels.popularMoviesViewModel.PopularMoviesViewModel
import com.example.cinemaxv3.viewmodels.topRatedMovieViewModel.TopRatedMovieViewModel
import com.example.cinemaxv3.viewmodels.upComingMoviesViewModel.UpComingMoviesViewModel
import com.example.educativecourseproject.R
import com.example.educativecourseproject.databinding.FragmentMoviesBinding
import kotlinx.coroutines.launch
class MoviesFragment : Fragment(R.layout.fragment_movies) {
    private lateinit var popularMovieAdapter: PopularMovieAdapter
    private lateinit var topRatedMoviesAdapter: TopRatedMoviesAdapter
    private val args: MovieDetailsFragmentArgs by navArgs()
    private lateinit var upComingMoviesAdapter: UpComingMoviesAdapter

    private val networkConnectivityObserver: ConnectivityObserverImpl by lazy {
        ConnectivityObserverImpl(requireContext())
    }

    private val topRatedMovieViewModel: TopRatedMovieViewModel by viewModels()
    private val popularMoviesViewModel: PopularMoviesViewModel by viewModels()
    private val upComingMoviesViewModel: UpComingMoviesViewModel by viewModels()

    @SuppressLint("SuspiciousIndentation")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentMoviesBinding.bind(view)
        val imageLoader = ImageLoader(requireContext())



        initMembers(imageLoader)
        checkNetworkConnectivity(binding)
        setUpViews(binding)
        fetchMovies(binding)
        displayPopularMovie(binding)
        recyclerViewOnClick()


        val actionBar = (activity as AppCompatActivity).supportActionBar
        actionBar?.apply {
            setDisplayHomeAsUpEnabled(false)
            setBackgroundDrawable(context?.let {
                ContextCompat.getColor(
                    it, R.color.black
                )
            }?.let { ColorDrawable(it) })
            title = "Cinemax cinematic"
        }


    }

    private fun initMembers(imageLoader: ImageLoader) {
        topRatedMoviesAdapter = TopRatedMoviesAdapter(imageLoader = imageLoader)
        popularMovieAdapter = PopularMovieAdapter(imageLoader = imageLoader)
        upComingMoviesAdapter = UpComingMoviesAdapter(imageLoader = imageLoader)


    }

    private fun checkNetworkConnectivity(binding: FragmentMoviesBinding) {

        lifecycleScope.launch {
            networkConnectivityObserver.observer().collect { status ->
                when (status) {
                    ConnectivityObserver.Status.Available -> displayPopularMovie(binding)
                    else -> {
                        binding.vote.text = "Offline"
                    }
                }
            }
        }
    }

    private fun fetchMovies(binding: FragmentMoviesBinding) {
        lifecycleScope.launch {
            topRatedMovieViewModel.topRatedMovieUiState.collect { uiState ->

                with(uiState) {

                    when {
                        isLoading -> {}

                        movies != null -> {
                            movies.collect {
                                topRatedMoviesAdapter.submitData(it)
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

        lifecycleScope.launch {
            popularMoviesViewModel.popularMoviesUiState.collect { uiState ->

                with(uiState) {
                    when {
                        isLoading -> {}

                        movies != null -> {
                            uiState.movies.collect {
                                popularMovieAdapter.submitData(it)
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

        lifecycleScope.launch {
            upComingMoviesViewModel.upComingMoviesState.collect { uiState ->

                with(uiState) {
                    when {
                        isLoading -> {}

                        movies != null -> {
                            uiState.movies.collect {
                                upComingMoviesAdapter.submitData(it)
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
    }


    private fun setUpViews(binding: FragmentMoviesBinding) {
        binding.topRatedMoviesRecyclerview.apply {
            layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
            adapter = topRatedMoviesAdapter
        }

        binding.popularMoviesRecyclerview.apply {
            layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
            adapter = popularMovieAdapter
        }

        binding.upComingMoviesRecyclerview.apply {
            layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
            adapter = upComingMoviesAdapter
        }
    }

    private fun recyclerViewOnClick() {

        popularMovieAdapter.setOnItemClickListener { movie ->

            with(movie) {
                val action = MoviesFragmentDirections.actionMoviesFragmentToMovieDetailsFragment(
                    IMAGE_BASE_URL + poster_path,
                    IMAGE_BASE_URL + backdrop_path,
                    title.toString(),
                    overview.toString(),
                    vote_average.toFloat(),
                    id
                )
                findNavController().navigate(action)
            }
        }


        topRatedMoviesAdapter.setOnItemClickListener { topRatedMovies ->

            with(topRatedMovies) {

                val action = MoviesFragmentDirections.actionMoviesFragmentToMovieDetailsFragment(
                    IMAGE_BASE_URL + poster_path,
                    IMAGE_BASE_URL + backdrop_path,
                    title.toString(),
                    overview.toString(),
                    vote_average.toFloat(),
                    id
                )
                findNavController().navigate(action)
            }

        }

        upComingMoviesAdapter.setOnItemClickListener { upComingMovies ->

            with(upComingMovies) {

                val action = MoviesFragmentDirections.actionMoviesFragmentToMovieDetailsFragment(
                    IMAGE_BASE_URL + poster_path,
                    IMAGE_BASE_URL + backdrop_path,
                    title.toString(),
                    overview.toString(),
                    vote_average.toFloat(),
                    id
                )
                findNavController().navigate(action)
            }
        }
    }

    private fun displayPopularMovie(binding: FragmentMoviesBinding) {
        lifecycleScope.launch {
            val it = popularMoviesViewModel.getTopRatedMovie()
            if (it != null) {
                for (i in 0 until it.size) {
                    if (it?.get(i)?.vote_average!! >= 8) {
                        binding.apply {
                            Glide.with(binding.popMov)
                                .load(Constants.IMAGE_BASE_URL + it[i].poster_path)
                                .into(popMov)
                            vote.text = it[i].vote_average.toString()
                        }
                        popularMovieOnclick(it[i].id, it[i].title, binding)
                    }
                }
            }
        }
    }


    private fun popularMovieOnclick(id: Int, name: String?, binding: FragmentMoviesBinding) {
        binding.btnTrailer.setOnClickListener {
            val bundle = Bundle()
            bundle.putInt("movieId", id)
            bundle.putString("title", name)
            findNavController().navigate(R.id.action_moviesFragment_to_movieDetailsFragment, bundle)
        }
    }

}
