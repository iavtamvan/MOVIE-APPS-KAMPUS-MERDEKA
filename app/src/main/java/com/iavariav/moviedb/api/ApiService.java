package com.iavariav.moviedb.api;


import com.iavariav.moviedb.model.MovieRootModel;
import com.iavariav.moviedb.teknik.model.TeknikRootModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("movie/now_playing?api_key=0dde3e9896a8c299d142e214fcb636f8")
    Call<MovieRootModel> ambilData();

    @GET("test.json")
    Call<TeknikRootModel> ambilDataTeknik();

}
