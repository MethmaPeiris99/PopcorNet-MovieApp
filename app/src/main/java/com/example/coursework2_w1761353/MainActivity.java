package com.example.coursework2_w1761353;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG_MAIN = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //------------- onClick() methods used to start each activity from the MainActivity using Intents -------------//
    public void launch_registerMovie_activity(View view) {
        Intent intent_registerMovie = new Intent(this,RegisterMovieActivity.class);
        startActivity(intent_registerMovie);

        Log.i(LOG_TAG_MAIN, " Started RegisterMovieActivity from MainActivity");
    }

    public void launch_displayMovies_activity(View view) {
        Intent intent_displayMovies = new Intent(this,DisplayMoviesActivity.class);
        startActivity(intent_displayMovies);

        Log.i(LOG_TAG_MAIN, " Started DisplayMoviesActivity from MainActivity");
    }

    public void launch_favourites_activity(View view) {
        Intent intent_favourites = new Intent(this,FavouritesActivity.class);
        startActivity(intent_favourites);

        Log.i(LOG_TAG_MAIN, " Started FavouritesActivity from MainActivity");
    }

    public void launch_editMovies_activity(View view) {
        Intent intent_editMovies = new Intent(this,EditMoviesActivity.class);
        startActivity(intent_editMovies);

        Log.i(LOG_TAG_MAIN, " Started EditMoviesActivity from MainActivity");
    }

    public void launch_search_activity(View view) {
        Intent intent_search = new Intent(this,SearchActivity.class);
        startActivity(intent_search);

        Log.i(LOG_TAG_MAIN, " Started SearchActivity from MainActivity");
    }

    public void launch_ratings_activity(View view) {
        Intent intent_ratings = new Intent(this,RatingsActivity.class);
        startActivity(intent_ratings);

        Log.i(LOG_TAG_MAIN, " Started RatingsActivity from MainActivity");
    }
}