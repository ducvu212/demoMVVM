package com.example.ducvu212.demomvvm.data.source.remote.config.service;

import com.example.ducvu212.demomvvm.data.model.MovieRespone;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by le.quang.dao on 10/03/2017.
 */

public interface NameApi {
    @GET("movie/now_playing?")
    Observable<MovieRespone> getAllMovieGenre(@Query("api_key") String apiKey,
            @Query("sort_by") String sort);
}
