package com.example.coursework2_w1761353;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class DisplayMoviesActivity extends AppCompatActivity {
    private static final String LOG_TAG_DISPLAY_MOVIES = DisplayMoviesActivity.class.getSimpleName(); //Initialize log name as the class name as a constant

    //------------------- Declare global variables -------------------//
    Movie movie;
    MovieDatabase movieDatabase;

    ListView listView;
    Button button;

    ArrayAdapter arrayAdapter;
    List<String> listOfMovieTitles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_movies);

        Log.i(LOG_TAG_DISPLAY_MOVIES," Started DisplayMoviesActivity");

        listView = findViewById(R.id.movieDisplay_listView_displayMovies);
        button = findViewById(R.id.addToFavourites_button_displayMovies);

        movie = new Movie(); //Create Movie class instance to access its methods
        movieDatabase = new MovieDatabase(this); //Create helper class instance to access its methods

        listOfMovieTitles = new ArrayList<>(); //Array list used to store retrieved movie titles from the database

        Cursor cursor = movieDatabase.getMovieTitles(); //Assign retrieved cursor value from the helper class method

        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE); //Allow user to select multiple choices in the list view

        while(cursor.moveToNext()){ //Move the cursor to the next row
            listOfMovieTitles.add(cursor.getString(0)); //Add cursor elements to the list of movie titles
            arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_multiple_choice,listOfMovieTitles); //Store movie titles in an array adapter
            listView.setAdapter(arrayAdapter); //Set the array adapter to the list view
        }

        Log.i(LOG_TAG_DISPLAY_MOVIES,"List of movie titles: "+listOfMovieTitles);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                for(int index=0; index<Movie.LIST_OF_MOVIES.size(); index++) {
                    if(Movie.LIST_OF_MOVIES.get(index).getMovieTitle().equals(arrayAdapter.getItem(position))){
                        Movie.LIST_OF_MOVIES.get(index).setMovieImpression(Movie.FAVOURITE_MOVIE_IMPRESSION_VALUE);
                        Movie.listOfFavouriteMovies.add(Movie.LIST_OF_MOVIES.get(position));
                    }
                }
                Log.i(LOG_TAG_DISPLAY_MOVIES,"List of favourite movies: "+Movie.listOfFavouriteMovies);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int index=0; index<Movie.listOfFavouriteMovies.size(); index++) {
                    movieDatabase.addFavouriteMovies(Movie.listOfFavouriteMovies.get(index));
                }
            }
        });
    }
}