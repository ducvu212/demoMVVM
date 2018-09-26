package com.example.ducvu212.demomvvm.screen.screen;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import com.example.ducvu212.demomvvm.R;
import com.example.ducvu212.demomvvm.data.repository.MovieRepository;
import com.example.ducvu212.demomvvm.data.source.remote.MovieRemoteDataSource;
import com.example.ducvu212.demomvvm.databinding.ActivityMainBinding;
import com.example.ducvu212.demomvvm.screen.base.BaseActivity;
import com.example.ducvu212.demomvvm.utils.rx.SchedulerProvider;

public class MainActivity extends BaseActivity {

    private MainViewModel mMainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MovieRepository movieRepository =
                MovieRepository.getsInstance(MovieRemoteDataSource.getsInstance());
        mMainViewModel = new MainViewModel(movieRepository);
        mMainViewModel.setSchedulerProvider(SchedulerProvider.getInstance());
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setViewModel(mMainViewModel);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mMainViewModel.onStart();
    }

    @Override
    protected void onStop() {
        mMainViewModel.onStop();
        super.onStop();
    }
}
