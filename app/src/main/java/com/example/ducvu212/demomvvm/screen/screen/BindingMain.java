package com.example.ducvu212.demomvvm.screen.screen;

import android.databinding.BindingAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.ducvu212.demomvvm.R;

/**
 * Created by CuD HniM on 18/10/01.
 */
public class BindingMain {

    @BindingAdapter({ "rating" })
    public static void setRating(RatingBar rating, double rate) {
        rating.setRating((float) (rate * 0.5));
    }

    @BindingAdapter({ "loadImg" })
    public static void loadImage(ImageView imageView, String url) {
        Glide.with(imageView.getContext())
                .load(url)
                .apply(new RequestOptions().placeholder(R.drawable.ic_launcher_foreground))
                .into(imageView);
    }
}
