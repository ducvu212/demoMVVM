package com.example.ducvu212.demomvvm.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.json.JSONException;
import org.json.JSONObject;

import static com.example.ducvu212.demomvvm.data.model.Result.JSONResults.RESULT_ADULT;
import static com.example.ducvu212.demomvvm.data.model.Result.JSONResults.RESULT_BACKDROP_PATH;
import static com.example.ducvu212.demomvvm.data.model.Result.JSONResults.RESULT_ID;
import static com.example.ducvu212.demomvvm.data.model.Result.JSONResults.RESULT_ORIGINAL_LANGUAGE;
import static com.example.ducvu212.demomvvm.data.model.Result.JSONResults.RESULT_ORIGINAL_TITLE;
import static com.example.ducvu212.demomvvm.data.model.Result.JSONResults.RESULT_OVERVIEW;
import static com.example.ducvu212.demomvvm.data.model.Result.JSONResults.RESULT_POPULARITY;
import static com.example.ducvu212.demomvvm.data.model.Result.JSONResults.RESULT_POSTER_PATH;
import static com.example.ducvu212.demomvvm.data.model.Result.JSONResults.RESULT_RELEASE_DATE;
import static com.example.ducvu212.demomvvm.data.model.Result.JSONResults.RESULT_TITLE;
import static com.example.ducvu212.demomvvm.data.model.Result.JSONResults.RESULT_VIDEO;
import static com.example.ducvu212.demomvvm.data.model.Result.JSONResults.RESULT_VOTE_AVERAGE;
import static com.example.ducvu212.demomvvm.data.model.Result.JSONResults.RESULT_VOTE_COUNT;

/**
 * Created by CuD HniM on 18/09/25.
 */
public class Result implements Parcelable {

    public static final Creator<Result> CREATOR = new Creator<Result>() {
        @Override
        public Result createFromParcel(Parcel source) {
            return new Result(source);
        }

        @Override
        public Result[] newArray(int size) {
            return new Result[size];
        }
    };
    @SerializedName(RESULT_VOTE_COUNT)
    @Expose
    private int mVoteCount;
    @SerializedName(RESULT_ID)
    @Expose
    private int mId;
    @SerializedName(RESULT_VIDEO)
    @Expose
    private boolean mVideo;
    @SerializedName(RESULT_VOTE_AVERAGE)
    @Expose
    private double mVoteAverage;
    @SerializedName(RESULT_TITLE)
    @Expose
    private String mTitle;
    @SerializedName(RESULT_POPULARITY)
    @Expose
    private double mPopularity;
    @SerializedName(RESULT_POSTER_PATH)
    @Expose
    private String mPosterPath;
    @SerializedName(RESULT_ORIGINAL_LANGUAGE)
    @Expose
    private String mOriginalLanguage;
    @SerializedName(RESULT_TITLE)
    @Expose
    private String mOriginalTitle;
    @SerializedName(RESULT_BACKDROP_PATH)
    @Expose
    private String mBackdropPath;
    @SerializedName(RESULT_ADULT)
    @Expose
    private boolean mAdult;
    @SerializedName(RESULT_OVERVIEW)
    @Expose
    private String mOverview;
    @SerializedName(RESULT_RELEASE_DATE)
    @Expose
    private String mReleaseDate;

    public Result(JSONObject jsonObject) throws JSONException {
        setVoteCount(jsonObject.getInt(RESULT_VOTE_COUNT));
        setId(jsonObject.getInt(RESULT_ID));
        setVideo(jsonObject.getBoolean(RESULT_VIDEO));
        setVoteAverage(jsonObject.getDouble(RESULT_VOTE_AVERAGE));
        setTitle(jsonObject.getString(RESULT_TITLE));
        setPopularity(jsonObject.getDouble(RESULT_POPULARITY));
        setPosterPath(jsonObject.getString(RESULT_POSTER_PATH));
        setOriginalLanguage(jsonObject.getString(RESULT_ORIGINAL_LANGUAGE));
        setOriginalTitle(jsonObject.getString(RESULT_ORIGINAL_TITLE));
        setBackdropPath(jsonObject.getString(RESULT_BACKDROP_PATH));
        setAdult(jsonObject.getBoolean(RESULT_ADULT));
        setOverview(jsonObject.getString(RESULT_OVERVIEW));
        setReleaseDate(jsonObject.getString(RESULT_RELEASE_DATE));
    }

    private Result(Builder builder) {
        setVoteCount(builder.mVoteCount);
        setId(builder.mId);
        setVideo(builder.mVideo);
        setVoteAverage(builder.mVoteAverage);
        setTitle(builder.mTitle);
        setPopularity(builder.mPopularity);
        setPosterPath(builder.mPosterPath);
        setOriginalLanguage(builder.mOriginalLanguage);
        setOriginalTitle(builder.mOriginalTitle);
        setBackdropPath(builder.mBackdropPath);
        setAdult(builder.mAdult);
        setOverview(builder.mOverview);
        setReleaseDate(builder.mReleaseDate);
    }

    protected Result(Parcel in) {
        mVoteCount = in.readInt();
        mId = in.readInt();
        mVideo = in.readByte() != 0;
        mVoteAverage = in.readDouble();
        mTitle = in.readString();
        mPopularity = in.readDouble();
        mPosterPath = in.readString();
        mOriginalLanguage = in.readString();
        mOriginalTitle = in.readString();
        mBackdropPath = in.readString();
        mAdult = in.readByte() != 0;
        mOverview = in.readString();
        mReleaseDate = in.readString();
    }

    public int getVoteCount() {
        return mVoteCount;
    }

    public void setVoteCount(int voteCount) {
        mVoteCount = voteCount;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public boolean getVideo() {
        return mVideo;
    }

    public void setVideo(boolean video) {
        mVideo = video;
    }

    public double getVoteAverage() {
        return mVoteAverage;
    }

    public void setVoteAverage(double voteAverage) {
        mVoteAverage = voteAverage;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public double getPopularity() {
        return mPopularity;
    }

    public void setPopularity(double popularity) {
        mPopularity = popularity;
    }

    public String getPosterPath() {
        return mPosterPath;
    }

    public void setPosterPath(String posterPath) {
        mPosterPath = posterPath;
    }

    public String getOriginalLanguage() {
        return mOriginalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        mOriginalLanguage = originalLanguage;
    }

    public String getOriginalTitle() {
        return mOriginalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        mOriginalTitle = originalTitle;
    }

    public String getBackdropPath() {
        return mBackdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        mBackdropPath = backdropPath;
    }

    public boolean getAdult() {
        return mAdult;
    }

    public void setAdult(boolean adult) {
        mAdult = adult;
    }

    public String getOverview() {
        return mOverview;
    }

    public void setOverview(String overview) {
        mOverview = overview;
    }

    public String getReleaseDate() {
        return mReleaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        mReleaseDate = releaseDate;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mVoteCount);
        dest.writeInt(mId);
        dest.writeByte(mVideo ? (byte) 1 : (byte) 0);
        dest.writeDouble(mVoteAverage);
        dest.writeString(mTitle);
        dest.writeDouble(mPopularity);
        dest.writeString(mPosterPath);
        dest.writeString(mOriginalLanguage);
        dest.writeString(mOriginalTitle);
        dest.writeString(mBackdropPath);
        dest.writeByte(mAdult ? (byte) 1 : (byte) 0);
        dest.writeString(mOverview);
        dest.writeString(mReleaseDate);
    }

    public static final class Builder {
        private int mVoteCount;
        private int mId;
        private boolean mVideo;
        private double mVoteAverage;
        private String mTitle;
        private double mPopularity;
        private String mPosterPath;
        private String mOriginalLanguage;
        private String mOriginalTitle;
        private String mBackdropPath;
        private boolean mAdult;
        private String mOverview;
        private String mReleaseDate;

        public Builder() {
        }

        public Builder mVoteCount(int voteCount) {
            mVoteCount = voteCount;
            return this;
        }

        public Builder mId(int id) {
            mId = id;
            return this;
        }

        public Builder mVideo(boolean video) {
            mVideo = video;
            return this;
        }

        public Builder mVoteAverage(double voteAverage) {
            mVoteAverage = voteAverage;
            return this;
        }

        public Builder mTitle(String title) {
            mTitle = title;
            return this;
        }

        public Builder mPopularity(double popularity) {
            mPopularity = popularity;
            return this;
        }

        public Builder mPosterPath(String posterPath) {
            mPosterPath = posterPath;
            return this;
        }

        public Builder mOriginalLanguage(String originalLanguage) {
            mOriginalLanguage = originalLanguage;
            return this;
        }

        public Builder mOriginalTitle(String originalTitle) {
            mOriginalTitle = originalTitle;
            return this;
        }

        public Builder mBackdropPath(String backdropPath) {
            mBackdropPath = backdropPath;
            return this;
        }

        public Builder mAdult(boolean adult) {
            mAdult = adult;
            return this;
        }

        public Builder mOverview(String overview) {
            mOverview = overview;
            return this;
        }

        public Builder mReleaseDate(String releaseDate) {
            mReleaseDate = releaseDate;
            return this;
        }

        public Result build() {
            return new Result(this);
        }
    }

    static class JSONResults {
        static final String RESULT_VOTE_COUNT = "vote_count";
        static final String RESULT_ID = "id";
        static final String RESULT_VIDEO = "video";
        static final String RESULT_VOTE_AVERAGE = "vote_average";
        static final String RESULT_TITLE = "title";
        static final String RESULT_POPULARITY = "popularity";
        static final String RESULT_POSTER_PATH = "poster_path";
        static final String RESULT_ORIGINAL_LANGUAGE = "original_language";
        static final String RESULT_ORIGINAL_TITLE = "original_title";
        static final String RESULT_BACKDROP_PATH = "backdrop_path";
        static final String RESULT_ADULT = "adult";
        static final String RESULT_OVERVIEW = "overview";
        static final String RESULT_RELEASE_DATE = "release_date";
    }
}
