package com.example.ducvu212.demomvvm.data.source.remote;

import com.example.ducvu212.demomvvm.BuildConfig;
import com.example.ducvu212.demomvvm.data.api.ApiClient;
import com.example.ducvu212.demomvvm.data.api.ApiInterface;
import com.example.ducvu212.demomvvm.data.model.Result;
import com.example.ducvu212.demomvvm.data.source.MovieDataSource;
import com.example.ducvu212.demomvvm.data.source.remote.config.service.NameApi;
import com.example.ducvu212.demomvvm.data.source.remote.config.service.NameServiceClient;
import io.reactivex.Observable;
import java.util.List;

import static com.example.ducvu212.demomvvm.utils.Constant.DEFAULT_SORT;

/**
 * Created by CuD HniM on 18/09/25.
 */
public class MovieRemoteDataSource implements MovieDataSource.MovieRemoteDataSource {

    private static MovieRemoteDataSource sInstance;

    public MovieRemoteDataSource(NameApi nameApi) {
        NameApi nameApi1 = nameApi;
    }

    public static synchronized MovieRemoteDataSource getsInstance() {
        if (sInstance == null) {
            synchronized (MovieRemoteDataSource.class) {
                if (sInstance == null) {
                    sInstance = new MovieRemoteDataSource(NameServiceClient.getInstance());
                }
            }
        }
        return sInstance;
    }

    @Override
    public Observable<List<Result>> getAllMovie() {
        return ApiClient.getInstance()
                .create(ApiInterface.class)
                .getAllMovieGenre(BuildConfig.API_KEY, DEFAULT_SORT)
                .flatMap(movieRespone -> Observable.just(movieRespone.getResults()));
    }
}
