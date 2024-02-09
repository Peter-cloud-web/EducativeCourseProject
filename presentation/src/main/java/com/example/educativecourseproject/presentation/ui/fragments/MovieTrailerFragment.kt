package com.example.educativecourseproject.presentation.ui.fragments

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import coil.ImageLoader
import com.example.cinemaxv3.view.ui.adapter.MovieCastsAdapter
import com.example.cinemaxv3.view.ui.adapter.SimilarMoviesAdapter
import com.example.cinemaxv3.viewmodels.movieCastViewModel.MovieCastsViewModel
import com.example.cinemaxv3.viewmodels.movieTrailerViewModel.MovieTrailerViewModel
import com.example.cinemaxv3.viewmodels.similarMoviesViewModel.SimilarMoviesViewModel
import com.example.domain.entities.model.movieCasts.Cast
import com.example.domain.entities.model.similarMoviesResponse.SimilarMovies
import com.example.educativecourseproject.R
import com.example.educativecourseproject.databinding.FragmentMovieTrailerBinding
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@AndroidEntryPoint
class MovieTrailerFragment : Fragment(R.layout.fragment_movie_trailer) {

    private val movieTrailerViewModel: MovieTrailerViewModel by viewModels()
    private val movieCastsViewModel: MovieCastsViewModel by viewModels()
    private val similarMoviesViewModel: SimilarMoviesViewModel by viewModels()

    private lateinit var videoView: YouTubePlayerView
    private lateinit var castsAdapter: MovieCastsAdapter
    private lateinit var similarMoviesAdapter: SimilarMoviesAdapter
    private val args: MovieTrailerFragmentArgs by navArgs()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentMovieTrailerBinding.bind(view)
        val imageLoader = ImageLoader(requireContext())

        castsAdapter = MovieCastsAdapter(imageLoader)
        similarMoviesAdapter = SimilarMoviesAdapter(imageLoader)
        videoView = binding.videoView

        val actionbar = requireActivity().actionBar
        actionbar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setBackgroundDrawable(context?.let {
                ContextCompat.getColor(
                    it,
                    R.color.black
                )
            }?.let { ColorDrawable(it) })
            title = "Trailers"
        }



        binding.apply {
            progressbar1.setVisibility(View.VISIBLE)
            progressbar2.setVisibility(View.VISIBLE)
        }

        collectArgumentsAndPerformOperations(binding)
        movieCastsRecyclerView(binding)
        similarMoviesRecyclerView(binding)
    }

    private fun collectArgumentsAndPerformOperations(binding: FragmentMovieTrailerBinding) {
        val id = args.movieId
        if (id != null) {
            movieCastsViewModel.movieCasts(id)
            similarMoviesViewModel.getSimilarMovies(id)
        }
        val title = args.title
        binding.movieName.text = title

        loadMovieCasts()
        loadSimilarMovies()
        playTrailers(id)
    }

    private fun playTrailers(id: Int) {

        lifecycleScope.launch(Dispatchers.Main) {

            movieTrailerViewModel.getMovieTrailer(id)
                .observe(viewLifecycleOwner, { movieTrailerResponse ->

                    videoView.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {

                        var resultKey: String = ""

                        override fun onReady(youTubePlayer: YouTubePlayer) {

                            super.onReady(youTubePlayer)

                            movieTrailerResponse.data?.apply {

                                for (i in 0..results.size - 1) {

                                    if (results[i].name == "Trailer") {

                                        resultKey = results[i].key.toString()

                                        youTubePlayer.loadVideo(
                                            videoId = results[i].key.toString(),
                                            0f
                                        )

                                    } else if (results[i].name == "Behind the Scenes") {

                                        youTubePlayer.loadVideo(
                                            videoId = results[i].key.toString(),
                                            0f
                                        )
                                    }
                                    youTubePlayer.loadVideo(videoId = results[i].key.toString(), 0f)
                                }
                            }
                        }

                        override fun onError(
                            youTubePlayer: YouTubePlayer,
                            error: PlayerConstants.PlayerError
                        ) {
                            super.onError(youTubePlayer, error)
                            val toast = Toast.makeText(
                                activity?.applicationContext,
                                "Error occured:${error.name.toString()}",
                                Toast.LENGTH_SHORT
                            )
                            toast.show()
//                            youTubePlayer.cueVideo(resultKey.toString(),0f)

                        }
                    })
                })
        }
    }

    fun loadMovieCasts() {
        val castList = mutableListOf<Cast>()
        lifecycleScope.launch(Dispatchers.IO) {

            movieCastsViewModel.movieCastResponse.collectLatest { uiState ->

                with(uiState) {

                    withContext(kotlinx.coroutines.Dispatchers.Main) {

                        when {
                            isLoading -> {}

                            movieCasts != null -> {
                                val casts = uiState.movieCasts
                                casts.collect {
                                    castList.addAll(listOf(it))
                                }
                                castsAdapter.comparator.submitList(castList)
                            }

                            error != null -> {
                                android.widget.Toast.makeText(
                                    requireContext(),
                                    "An unexpected error occurred, When loading casts",
                                    android.widget.Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                    }
                }
            }
        }
    }

    fun movieCastsRecyclerView(binding: FragmentMovieTrailerBinding) {
        binding.recyclerviewMovieCasts.apply {
            layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
            adapter = castsAdapter
            binding.progressbar1.setVisibility(View.GONE)
        }
    }

    fun loadSimilarMovies() {
        val similarMoviesResults =
            mutableListOf<SimilarMovies>()
        lifecycleScope.launch {
            similarMoviesViewModel.similarMovies.collectLatest { uiState ->

                with(uiState) {

                    when {
                        isLoading -> {}

                        similarMovies != null -> {
                            val similarMoviesResponse = uiState.similarMovies
                            similarMoviesResponse?.collect {
                                similarMoviesResults.addAll(listOf(it))
                            }
                            similarMoviesAdapter.similarMoviesDifferList.submitList(
                                similarMoviesResults
                            )
                        }

                        error != null -> {
                            android.widget.Toast.makeText(
                                requireContext(),
                                "An unexpected error occurred, When loading similar movies",
                                android.widget.Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                }
            }
        }
    }

    fun similarMoviesRecyclerView(binding: FragmentMovieTrailerBinding) {
        binding.recyclerviewSimilar.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerviewSimilar.adapter = similarMoviesAdapter
        binding.progressbar2.setVisibility(View.GONE)
    }

}