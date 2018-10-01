package com.example.ducvu212.demomvvm.screen.screen;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.example.ducvu212.demomvvm.R;
import com.example.ducvu212.demomvvm.data.model.Result;
import com.example.ducvu212.demomvvm.databinding.ItemMovieBinding;
import java.util.List;

import static com.example.ducvu212.demomvvm.utils.Constant.BASE_URL_POSTER;

/**
 * Created by CuD HniM on 18/09/26.
 */
public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainHolder> {

    private List<Result> mResults;
    private Context mContext;

    public MainAdapter(Context context) {
        mContext = context;
    }

    public void setData(List<Result> results) {
        mResults = results;
    }

    @NonNull
    @Override
    public MainHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ItemMovieBinding binding =
                DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()),
                        R.layout.item_movie, viewGroup, false);
        return new MainHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MainHolder mainHolder, int i) {
        mainHolder.binding(mResults.get(i), mContext);
    }

    @Override
    public int getItemCount() {
        return mResults == null ? 0 : mResults.size();
    }

    static class MainHolder extends RecyclerView.ViewHolder {

        private ItemMovieBinding mBinding;

        MainHolder(@NonNull ItemMovieBinding itemView) {
            super(itemView.getRoot());
            mBinding = itemView;
        }

        void binding(Result result, Context context) {
            String posterPath = result.getPosterPath();
            if (!posterPath.contains(BASE_URL_POSTER)) {
                result.setPosterPath(BASE_URL_POSTER.concat(posterPath));
            }
            mBinding.setResult(result);
            mBinding.setListener(new HandleItemClick(context));
        }
    }
}
