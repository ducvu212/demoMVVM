package com.example.ducvu212.demomvvm.data.repository;

import com.example.ducvu212.demomvvm.data.model.Result;
import com.example.ducvu212.demomvvm.data.source.remote.MovieRemoteDataSource;
import io.reactivex.Observable;
import java.util.List;

/**
 * Created by CuD HniM on 18/09/26.
 */
public class MovieRepository {

    private static MovieRepository sInstance;
    private MovieRemoteDataSource mRemoteDataSource;

    public MovieRepository(MovieRemoteDataSource remoteDataSource) {
        mRemoteDataSource = remoteDataSource;
    }

    public static synchronized MovieRepository getsInstance(
            MovieRemoteDataSource remoteDataSource) {
        if (sInstance == null) {
            synchronized (MovieRepository.class) {
                if (sInstance == null) {
                    sInstance = new MovieRepository(remoteDataSource);
                }
            }
        }
        return sInstance;
    }

    public Observable<List<Result>> getAllFilmGenre() {
        return mRemoteDataSource.getAllMovie();
    }
}
