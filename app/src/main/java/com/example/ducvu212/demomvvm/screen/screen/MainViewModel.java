package com.example.ducvu212.demomvvm.screen.screen;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LifecycleRegistry;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import com.example.ducvu212.demomvvm.R;
import com.example.ducvu212.demomvvm.data.model.Result;
import com.example.ducvu212.demomvvm.data.repository.MovieRepository;
import com.example.ducvu212.demomvvm.screen.base.BaseViewModel;
import com.example.ducvu212.demomvvm.utils.common.StringUtils;
import com.example.ducvu212.demomvvm.utils.rx.BaseSchedulerProvider;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by CuD HniM on 18/09/26.
 */
public class MainViewModel extends BaseViewModel implements LifecycleOwner {

    private MovieRepository mRepository;
    private BaseSchedulerProvider mSchedulerProvider;
    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();
    private Context mContext;
    private MutableLiveData mData;
    private MainAdapter mAdapter;
    private List<Result> mResults;
    private ObservableField<MainAdapter> mMainAdapterObservable = new ObservableField<>();
    private LifecycleRegistry mLifecycleRegistry;

    MainViewModel(Context context, MovieRepository movieRepository) {
        mContext = context.getApplicationContext();
        mRepository = movieRepository;
        mData = new MutableLiveData();
        mLifecycleRegistry = new LifecycleRegistry(this);
        mLifecycleRegistry.markState(Lifecycle.State.CREATED);
    }

    void setSchedulerProvider(BaseSchedulerProvider schedulerProvider) {
        mSchedulerProvider = schedulerProvider;
    }

    public ObservableField<MainAdapter> getMainAdapterObservable() {
        return mMainAdapterObservable;
    }

    @Override
    protected void onStart() {
        mLifecycleRegistry.markState(Lifecycle.State.STARTED);
        setupData();
    }

    @Override
    protected void onStop() {
        mCompositeDisposable.clear();
    }

    LiveData<List<Result>> callAPILoadMovie(MainAdapter adapter) {
        mMainAdapterObservable.set(adapter);
        Disposable disposable = mRepository.getAllFilmGenre()
                .subscribeOn(mSchedulerProvider.io())
                .observeOn(mSchedulerProvider.ui())
                .subscribe(results -> mData.setValue(results), throwable -> {
                    mData.setValue(null);
                    StringUtils.showToast(mContext, mContext.getString(R.string.load_data_error));
                });
        mCompositeDisposable.add(disposable);
        return mData;
    }

    private void setupData() {
        mAdapter = new MainAdapter(mContext);
        mResults = new ArrayList<>();
        mAdapter.setData(mResults);
        callAPILoadMovie(mAdapter).observe(this, results -> {
            mResults.clear();
            mResults = results;
            mAdapter.notifyDataSetChanged();
            mAdapter.setData(mResults);
        });
    }

    @NonNull
    @Override
    public Lifecycle getLifecycle() {
        return mLifecycleRegistry;
    }
}
