package com.example.coursework2_w1761353;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class SearchActivity extends AppCompatActivity {
    private static final String LOG_TAG_SEARCH = SearchActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        Log.i(LOG_TAG_SEARCH," Started SearchActivity");
    }
}