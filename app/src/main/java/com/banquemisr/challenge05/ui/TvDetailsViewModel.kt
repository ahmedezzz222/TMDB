package com.banquemisr.challenge05.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.banquemisr.challenge05.remoteSource.TvResponseDetails
import com.banquemisr.challenge05.repositories.RepositoryTvDetailsData

class TvDetailsViewModel(application: Application) : AndroidViewModel(application){

    fun getTvShowDetails(tvId : String): LiveData<TvResponseDetails> {
        return RepositoryTvDetailsData.getTvShowsDetails(tvId)
    }
}