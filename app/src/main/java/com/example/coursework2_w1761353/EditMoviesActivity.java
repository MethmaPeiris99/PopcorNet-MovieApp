package com.example.coursework2_w1761353;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class EditMoviesActivity extends AppCompatActivity {
    private static final String LOG_TAG_EDIT_MOVIES = EditMoviesActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_movies);

        Log.i(LOG_TAG_EDIT_MOVIES," Started EditMoviesActivity");
    }
}