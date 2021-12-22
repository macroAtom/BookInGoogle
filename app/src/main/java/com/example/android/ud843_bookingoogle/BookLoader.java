package com.example.android.ud843_bookingoogle;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

import java.util.List;

public class BookLoader extends AsyncTaskLoader<List<Book>> {

    /**
     *
     */
    private String mJsonUrl;

    public BookLoader(@NonNull Context context, String jsonUrl) {
        super(context);
        this.mJsonUrl = jsonUrl;

    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
//        forceLoad();
    }


    @Nullable
    @Override
    public List<Book> loadInBackground() {
        List<Book> book = QueryUtils.extractBookJson(mJsonUrl);
        return book;
    }
}
