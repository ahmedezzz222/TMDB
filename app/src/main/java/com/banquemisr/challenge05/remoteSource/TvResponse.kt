package com.banquemisr.challenge05.remoteSource

data class TvResponse(val results : List<TvShow>)

data class TvShow (val poster_path : String, val original_name: String, val id : Int)