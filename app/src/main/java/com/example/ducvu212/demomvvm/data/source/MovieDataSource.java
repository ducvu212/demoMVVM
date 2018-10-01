package com.example.ducvu212.demomvvm.data.source;

import io.reactivex.Observable;

/**
 * Created by CuD HniM on 18/09/25.
 */
public interface MovieDataSource {

    interface MovieRemoteDataSource {
        Observable getAllMovie();
    }

    interface MovieLocalDataSource {

    }
}
