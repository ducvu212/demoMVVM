package com.example.ducvu212.demomvvm.screen.screen;

import android.content.Context;
import com.example.ducvu212.demomvvm.data.model.Result;
import com.example.ducvu212.demomvvm.utils.common.StringUtils;

/**
 * Created by CuD HniM on 18/10/01.
 */
public class HandleItemClick {

    private Context mContext;

    HandleItemClick(Context context) {
        mContext = context.getApplicationContext();
    }

    public void OnItemClickListener(Result result) {
        StringUtils.showToast(mContext, result.getTitle());
    }
}
