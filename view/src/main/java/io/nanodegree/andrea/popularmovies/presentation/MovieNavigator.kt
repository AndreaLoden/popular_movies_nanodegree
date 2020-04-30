package io.nanodegree.andrea.popularmovies.presentation

import android.view.View
import androidx.fragment.app.Fragment
import com.jetbrains.handson.mpp.mobile.MovieContainer

interface MovieNavigator {
    fun navigateToMovieDetailFragment(movie: MovieContainer.Movie, originFragment: Fragment, posterImageView: View)
}