package com.jetbrains.handson.mpp.mobile

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MovieDetailPresenter(private val movieDetailView: MovieDetailView, private val movieDetailCase: MovieDetailCase) {

    fun start(id: String) {

        GlobalScope.apply {
            launch(Background) {

                val reviews = async { movieDetailCase.getMovieReviewsRepo(id) }
                val trailers = async { movieDetailCase.getMovieTrailersRepo(id) }

                withContext(Main) {
                    movieDetailView.showState(
                        MovieDetailState(
                            reviews.await(),
                            trailers.await()
                        )
                    )
                }
            }
        }
    }
}