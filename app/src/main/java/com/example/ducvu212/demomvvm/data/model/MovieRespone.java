package com.example.ducvu212.demomvvm.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Created by CuD HniM on 18/09/25.
 */
public class MovieRespone {

    @SerializedName("results")
    @Expose
    private List<Result> mResults;
    @SerializedName("page")
    @Expose
    private Integer mPage;
    @SerializedName("total_results")
    @Expose
    private Integer mTotalResults;
    @SerializedName("total_pages")
    @Expose
    private Integer mTotalPages;

    private MovieRespone(Builder builder) {
        setResults(builder.mResults);
        setPage(builder.mPage);
        setTotalResults(builder.mTotalResults);
        setTotalPages(builder.mTotalPages);
    }

    public List<Result> getResults() {
        return mResults;
    }

    private void setResults(List<Result> results) {
        mResults = results;
    }

    public Integer getPage() {
        return mPage;
    }

    public void setPage(Integer page) {
        mPage = page;
    }

    public Integer getTotalResults() {
        return mTotalResults;
    }

    public void setTotalResults(Integer totalResults) {
        mTotalResults = totalResults;
    }

    public Integer getTotalPages() {
        return mTotalPages;
    }

    public void setTotalPages(Integer totalPages) {
        mTotalPages = totalPages;
    }

    public static final class Builder {
        private List<Result> mResults;
        private Integer mPage;
        private Integer mTotalResults;
        private Integer mTotalPages;

        public Builder() {
        }

        public Builder results(List<Result> results) {
            mResults = results;
            return this;
        }

        public Builder page(Integer page) {
            mPage = page;
            return this;
        }

        public Builder totalResults(Integer totalResults) {
            mTotalResults = totalResults;
            return this;
        }

        public Builder totalPages(Integer totalPages) {
            mTotalPages = totalPages;
            return this;
        }

        public MovieRespone build() {
            return new MovieRespone(this);
        }
    }

    static class JsonMovieRespone {
        static final String JSON_RESULT = "results";
        static final String JSON_PAGE = "page";
        static final String JSON_TOTAL_RESULT = "total_results";
        static final String JSON_TOTAL_PAGE = "total_results";
    }
}
