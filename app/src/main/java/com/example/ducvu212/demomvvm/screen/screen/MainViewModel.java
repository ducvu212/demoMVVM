package com.example.ducvu212.demomvvm.screen.screen;

import com.example.ducvu212.demomvvm.data.repository.MovieRepository;
import com.example.ducvu212.demomvvm.screen.base.BaseViewModel;
import com.example.ducvu212.demomvvm.utils.rx.BaseSchedulerProvider;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by CuD HniM on 18/09/26.
 */
public class MainViewModel extends BaseViewModel {

    private MovieRepository mRepository;
    private BaseSchedulerProvider mSchedulerProvider;
    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    public MainViewModel(MovieRepository movieRepository) {
        mRepository = movieRepository;
    }

    public void setSchedulerProvider(BaseSchedulerProvider schedulerProvider) {
        mSchedulerProvider = schedulerProvider;
    }

    @Override
    protected void onStart() {
        callAPISearchUsers();
    }

    @Override
    protected void onStop() {
        mCompositeDisposable.clear();
    }

    private void callAPISearchUsers() {
        Disposable disposable = mRepository.getAllFilmGenre()
                .subscribeOn(mSchedulerProvider.io())
                .observeOn(mSchedulerProvider.ui())
                .subscribe(results -> {
                    //On Success Log Data
                }, throwable -> {
                    //On Error Log Throwable
                });
        mCompositeDisposable.add(disposable);
    }
}
