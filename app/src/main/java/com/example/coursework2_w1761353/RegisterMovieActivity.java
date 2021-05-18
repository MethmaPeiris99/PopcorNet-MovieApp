package com.example.coursework2_w1761353;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

public class RegisterMovieActivity extends AppCompatActivity {
    private static final String LOG_TAG_REGISTER_MOVIE = RegisterMovieActivity.class.getSimpleName(); //Initialize log name as the class name, as a constant

    //------------------------------------- Declare global variables -------------------------------------//
    Movie movie;
    MovieDatabase movieDatabase;

    EditText titleEditText, yearEditText, directorEditText, actorListEditText, ratingEditText, reviewEditText;
    Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_movie);

        Log.i(LOG_TAG_REGISTER_MOVIE," Started RegisterMovieActivity");

        //------- Assigning EditText views found by using their ids -------//
        titleEditText = findViewById(R.id.title_editText_registerMovie);
        yearEditText = findViewById(R.id.year_editText_registerMovie);
        directorEditText = findViewById(R.id.director_editText_registerMovie);
        actorListEditText = findViewById(R.id.actorList_editText_registerMovie);
        ratingEditText = findViewById(R.id.rating_editText_registerMovie);
        reviewEditText = findViewById(R.id.review_editText_registerMovie);

        saveButton = findViewById(R.id.save_button_registerMovie); //Assigning the Button view found by using its id

        movieDatabase = new MovieDatabase(this); //Creating a new helper class instance

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Movie movieDetails = initializeMovieUsingInput(); //Get movie details returned by the method which initialize movie details by using input
                movieDatabase.addMovieDetails(movieDetails); //Add movie details to the database

                Snackbar snackbar = Snackbar
                        .make(v, "Movie details SAVED SUCCESSFULLY!", Snackbar.LENGTH_LONG);
                snackbar.show(); //Display a message to the user if the data saving is successful
            }
        });
    }

    public Movie initializeMovieUsingInput(){
        //---- Initializing movie details by retrieving inputs from EditTexts ----//
        String movieTitle = titleEditText.getText().toString();
        Log.i(LOG_TAG_REGISTER_MOVIE,"Movie Title: "+movieTitle);

        String movieYearInString = yearEditText.getText().toString();
        int movieYear = Integer.parseInt(movieYearInString);
        Log.i(LOG_TAG_REGISTER_MOVIE,"Movie Year: "+movieYear);

        String movieDirector = directorEditText.getText().toString();
        Log.i(LOG_TAG_REGISTER_MOVIE,"Movie Director: "+movieDirector);

        String movieActorList = actorListEditText.getText().toString();
        Log.i(LOG_TAG_REGISTER_MOVIE,"Movie Actor List: "+movieActorList);

        String movieRatingInString = ratingEditText.getText().toString();
        int movieRating = Integer.parseInt(movieRatingInString);
        Log.i(LOG_TAG_REGISTER_MOVIE,"Movie Rating: "+movieRating);

        String movieReview = reviewEditText.getText().toString();
        Log.i(LOG_TAG_REGISTER_MOVIE,"Movie Review: "+movieReview);

        //-------------- Create movie instance using the input movie details --------------//
        movie = new Movie(movieTitle,movieYear,movieDirector,movieActorList,movieRating,movieReview);

        Movie.LIST_OF_MOVIES.add(movie); //Adding the created movie instance to the movie list

        Log.i(LOG_TAG_REGISTER_MOVIE,"Movie Details: "+movie.toString());

        return movie;
    }
}