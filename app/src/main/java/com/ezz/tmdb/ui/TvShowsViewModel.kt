package com.ezz.tmdb.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.ezz.tmdb.remoteSource.TvShow
import com.ezz.tmdb.repositories.RepositoryTvShowData

class TvShowsViewModel(application: Application) : AndroidViewModel(application) {

    fun getTvShows(tvType : String) : LiveData<List<TvShow>> {
        return RepositoryTvShowData.getTvShows(tvType)
    }
}