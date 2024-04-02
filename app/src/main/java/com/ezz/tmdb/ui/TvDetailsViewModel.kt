package com.ezz.tmdb.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.ezz.tmdb.remoteSource.TvResponseDetails
import com.ezz.tmdb.repositories.RepositoryTvDetailsData

class TvDetailsViewModel(application: Application) : AndroidViewModel(application){

    fun getTvShowDetails(tvId : String): LiveData<TvResponseDetails> {
        return RepositoryTvDetailsData.getTvShowsDetails(tvId)
    }
}