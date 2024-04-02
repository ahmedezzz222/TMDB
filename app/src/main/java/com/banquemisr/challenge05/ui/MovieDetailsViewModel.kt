package com.banquemisr.challenge05.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.banquemisr.challenge05.remoteSource.MovieResponseDetails
import com.banquemisr.challenge05.repositories.RepositoryMovieDetailsData

class MovieDetailsViewModel(application: Application) : AndroidViewModel(application) {

    fun getMovieDetails(movieId : String) : LiveData<MovieResponseDetails> {
        return RepositoryMovieDetailsData.getMovieDetail(movieId)
    }
}