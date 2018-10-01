package com.example.ducvu212.demomvvm.data.api;

import com.example.ducvu212.demomvvm.data.model.MovieRespone;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("discover/movie?")
    Observable<MovieRespone> getAllMovieGenre(@Query("api_key") String apiKey,
            @Query("sort_by") String sort);
}
