package com.ezz.tmdb.repositories

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.ezz.tmdb.AppConstants
import com.ezz.tmdb.remoteSource.APIClient
import com.ezz.tmdb.remoteSource.ApiInterface
import com.ezz.tmdb.remoteSource.TvResponse
import com.ezz.tmdb.remoteSource.TvShow
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object RepositoryTvShowData {

    private val apiInterface = APIClient.getRetrofit().create(ApiInterface::class.java)

    private lateinit var tvShowList  : List<TvShow>

    val tvShowsPopular : MutableLiveData<List<TvShow>> by lazy { MutableLiveData<List<TvShow>>() }
    val tvShowsTopRated : MutableLiveData<List<TvShow>> by lazy { MutableLiveData<List<TvShow>>() }
    val tvShowsOnTheAir : MutableLiveData<List<TvShow>> by lazy { MutableLiveData<List<TvShow>>() }
    val tvShowsAiring : MutableLiveData<List<TvShow>> by lazy { MutableLiveData<List<TvShow>>() }

    fun getTvShows(tvType : String) : MutableLiveData<List<TvShow>> {

        val call : Call<TvResponse> = apiInterface.getTvShow(tvType, AppConstants.API_KEY)

        call.enqueue(object : Callback<TvResponse> {

            override fun onResponse(
                call: Call<TvResponse>,
                response: Response<TvResponse>
            ) {

                if(response.isSuccessful){

                    tvShowList = response.body()!!.results

                    when (tvType) {
                        AppConstants.POPULAR -> { tvShowsPopular.postValue(
                            tvShowList
                        ) }
                        AppConstants.TOP_RATED -> { tvShowsTopRated.postValue(
                            tvShowList
                        ) }
                        AppConstants.ON_THE_AIR -> { tvShowsOnTheAir.postValue(
                            tvShowList
                        ) }
                        else -> { tvShowsAiring.postValue(tvShowList) }
                    }
                }
            }

            override fun onFailure(call: Call<TvResponse>, t: Throwable) {

                Log.e("Failure",t.message.toString())
            }

        })
        return when(tvType){
            AppConstants.POPULAR -> tvShowsPopular
            AppConstants.TOP_RATED -> tvShowsTopRated
            AppConstants.ON_THE_AIR -> tvShowsOnTheAir
            else -> tvShowsAiring
        }
    }

}