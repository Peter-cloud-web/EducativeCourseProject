package com.example.educativecourseproject.presentation.ui.fragments

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import coil.ImageLoader
import com.example.cinemaxv3.util.Constants
import com.example.cinemaxv3.view.ui.adapter.SearchMoviesAdapter
import com.example.cinemaxv3.viewmodels.searchedMoviesViewModel.SearchedMoviesViewModel
import com.example.educativecourseproject.R
import com.example.educativecourseproject.data.mappers.Mappers.toPopularMovie
import com.example.educativecourseproject.databinding.FragmentSearchMovieBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Job
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SearchMovieFragment : Fragment(R.layout.fragment_search_movie) {

    private lateinit var searchMoviesAdapter: SearchMoviesAdapter
    private val searchedMoviesViewModel: SearchedMoviesViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentSearchMovieBinding.bind(view)
        val imageLoader = ImageLoader(requireContext())

        searchMoviesAdapter = SearchMoviesAdapter(imageLoader)

        handleActioBar()
        searchMovies(binding)
        submitMovies(binding)
        handleOnClick()
    }

    private fun handleActioBar(){
        val actionbar = (activity as AppCompatActivity).supportActionBar
        actionbar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setBackgroundDrawable(context?.let {
                ContextCompat.getColor(
                    it,
                    R.color.black
                )
            }?.let { ColorDrawable(it) })
            title = "Search Movies"
        }
    }

    private fun searchMovies(binding: FragmentSearchMovieBinding){
        var job: Job? = null
        binding.searchView.addTextChangedListener { searchEditText ->
            job?.cancel()
            job = MainScope().launch() {
                delay(Constants.SEARCH_NEWS_TIME_DELAY)
                searchEditText?.let { editText ->
                    if (editText.toString().isNotEmpty()) {
                        searchedMoviesViewModel.searchMovies(editText.toString())
                    }
                }
            }
        }
    }

    private fun submitMovies(binding: FragmentSearchMovieBinding){
        searchedMoviesViewModel.SearchResponse.observe(viewLifecycleOwner, Observer { response ->
            searchMoviesAdapter.searchMovies.submitList(response?.results?.map { movie->
                movie.toPopularMovie()
            })
        })

        binding.searchRecyclerView.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = searchMoviesAdapter
        }
    }

    private fun handleOnClick(){
        searchMoviesAdapter.setOnItemClickListener { movie ->

            with(movie) {

                val action = SearchMovieFragmentDirections.actionSearchMovieFragment2ToMovieDetailsFragment(
                    Constants.IMAGE_BASE_URL + poster_path,
                    Constants.IMAGE_BASE_URL + backdrop_path,
                    title.toString(),
                    overview.toString(),
                    vote_average.toFloat(),
                    id
                )
                findNavController().navigate(action)

            }
        }
    }

}