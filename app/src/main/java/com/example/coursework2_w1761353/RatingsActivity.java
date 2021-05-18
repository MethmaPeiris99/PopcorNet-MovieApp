package com.example.coursework2_w1761353;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class RatingsActivity extends AppCompatActivity {
    private static final String LOG_TAG_RATINGS = RatingsActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ratings);

        Log.i(LOG_TAG_RATINGS," Started RatingsActivity");
    }
}