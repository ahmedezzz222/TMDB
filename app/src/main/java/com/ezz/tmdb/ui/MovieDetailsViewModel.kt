package com.ezz.tmdb.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.ezz.tmdb.remoteSource.MovieResponseDetails
import com.ezz.tmdb.repositories.RepositoryMovieDetailsData

class MovieDetailsViewModel(application: Application) : AndroidViewModel(application) {

    fun getMovieDetails(movieId : String) : LiveData<MovieResponseDetails> {
        return RepositoryMovieDetailsData.getMovieDetail(movieId)
    }
}