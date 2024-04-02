package com.banquemisr.challenge05.repositories

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.banquemisr.challenge05.AppConstants
import com.banquemisr.challenge05.remoteSource.APIClient
import com.banquemisr.challenge05.remoteSource.ApiInterface
import com.banquemisr.challenge05.remoteSource.TvResponseDetails
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object RepositoryTvDetailsData {

    private val apiInterface = APIClient.getRetrofit().create(ApiInterface::class.java)

    val tvShowDetails : MutableLiveData<TvResponseDetails> by lazy { MutableLiveData<TvResponseDetails>() }

    fun getTvShowsDetails(tvId : String) : MutableLiveData<TvResponseDetails> {

        val call = apiInterface.getTvShowDetails(tvId, AppConstants.API_KEY)

        call.enqueue(object : Callback<TvResponseDetails> {

            override fun onResponse(
                call: Call<TvResponseDetails>,
                response: Response<TvResponseDetails>
            ) {

                if(response.isSuccessful){

                    tvShowDetails.postValue(response.body()!!)

                }
            }

            override fun onFailure(call: Call<TvResponseDetails>, t: Throwable) {

                Log.e("Failure",t.message.toString())
            }

        })
        return tvShowDetails
    }

}