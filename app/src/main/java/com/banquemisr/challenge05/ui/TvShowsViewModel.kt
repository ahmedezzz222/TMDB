package com.banquemisr.challenge05.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.banquemisr.challenge05.remoteSource.TvShow
import com.banquemisr.challenge05.repositories.RepositoryTvShowData

class TvShowsViewModel(application: Application) : AndroidViewModel(application) {

    fun getTvShows(tvType : String) : LiveData<List<TvShow>> {
        return RepositoryTvShowData.getTvShows(tvType)
    }
}