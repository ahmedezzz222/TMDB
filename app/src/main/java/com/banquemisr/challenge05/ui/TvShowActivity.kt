package com.banquemisr.challenge05.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.banquemisr.challenge05.AppConstants
import com.banquemisr.challenge05.R
import com.banquemisr.challenge05.remoteSource.*
import com.banquemisr.challenge05.adapters.TvShowAdapter
import kotlinx.android.synthetic.main.activity_tv_show.*


class TvShowActivity : AppCompatActivity() {

    private lateinit var viewModel : TvShowsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tv_show)

        viewModel = ViewModelProvider(this).get(TvShowsViewModel :: class.java)

        getRecyclerViewData(AppConstants.POPULAR)
        getRecyclerViewData(AppConstants.TOP_RATED)
        getRecyclerViewData(AppConstants.ON_THE_AIR)
        getRecyclerViewData(AppConstants.AIRING_TODAY)

    }

    private fun getRecyclerViewData(type : String){
        viewModel.getTvShows(type).observe(this, Observer {
            populateTvShowRecycler(it,

                when (type){
                    AppConstants.POPULAR -> popular_recycler
                    AppConstants.TOP_RATED -> top_rated_recycler
                    AppConstants.ON_THE_AIR-> on_the_air_recycler
                    else -> airing_today_recycler
                }
            )
        })
    }

    private fun populateTvShowRecycler(tvShowList: List<TvShow>, recyclerView: RecyclerView) {
        recyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        recyclerView.adapter = TvShowAdapter(tvShowList)
    }

}