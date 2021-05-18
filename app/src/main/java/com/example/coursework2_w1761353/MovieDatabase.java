package com.example.coursework2_w1761353;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

//---------------------- Helper class ----------------------//
public class MovieDatabase extends SQLiteOpenHelper {

    private static final String LOG_TAG_MOVIE_DATABASE = MovieDatabase.class.getSimpleName();

    //Initializing the Database version, Database name and table name as constants//
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Movie_Details";
    private static final String TABLE_NAME = "Movies";

    //------ Initializing the attributes as constants ------//
    private static final String MOVIE_TITLE = "title";
    private static final String MOVIE_YEAR = "year";
    private static final String MOVIE_DIRECTOR = "director";
    private static final String MOVIE_ACTOR_LIST = "actor_list";
    private static final String MOVIE_RATING = "rating";
    private static final String MOVIE_REVIEW = "review";
    private static final String MOVIE_IMPRESSION = "favourites";

    //----- Declare instance variables -----//
    private SQLiteDatabase database;

    //---------------- Constructor of the Helper class ----------------//
    public MovieDatabase(Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    //-------------- Method used to create the database ---------------//
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+TABLE_NAME+"("
        +MOVIE_TITLE+" TEXT,"
        +MOVIE_YEAR+" INTEGER,"
        +MOVIE_DIRECTOR+" TEXT,"
        +MOVIE_ACTOR_LIST+" TEXT,"
        +MOVIE_RATING+" INTEGER,"
        +MOVIE_REVIEW+" TEXT,"
        +MOVIE_IMPRESSION+" INTEGER"+");");
    }

    //Method used to update the version of the database every time if some change is done by dropping the table and creating it again with the changes//
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    //------------- Method used to add movie data to the database -------------//
    public void addMovieDetails(Movie movie){
        database = getWritableDatabase(); //Create and/or open the database that will be used for reading and writing

        ContentValues contentValues = new ContentValues(); //Used to store a set of movie details

        contentValues.put(MOVIE_TITLE, movie.getMovieTitle());
        Log.i(LOG_TAG_MOVIE_DATABASE,"Movie Title: "+movie.getMovieTitle());

        contentValues.put(MOVIE_YEAR, movie.getMovieYear());
        Log.i(LOG_TAG_MOVIE_DATABASE,"Movie Year: "+movie.getMovieYear());

        contentValues.put(MOVIE_DIRECTOR, movie.getMovieDirector());
        Log.i(LOG_TAG_MOVIE_DATABASE,"Movie Director: "+movie.getMovieDirector());

        contentValues.put(MOVIE_ACTOR_LIST, movie.getMovieActorList());
        Log.i(LOG_TAG_MOVIE_DATABASE,"Movie Actor List: "+movie.getMovieActorList());

        contentValues.put(MOVIE_RATING, movie.getMovieRating());
        Log.i(LOG_TAG_MOVIE_DATABASE,"Movie Rating: "+movie.getMovieRating());

        contentValues.put(MOVIE_REVIEW, movie.getMovieReview());
        Log.i(LOG_TAG_MOVIE_DATABASE,"Movie Review: "+movie.getMovieReview());

        Log.i(LOG_TAG_MOVIE_DATABASE,"Content values: "+contentValues);
        database.insert(TABLE_NAME,null,contentValues); //Add content values which consists of movie details to the database
    }

    //------------ Method used to retrieve movie titles from the database ------------//
    public Cursor getMovieTitles(){
        database = getReadableDatabase(); //Create and/or open the database

        //--- Get all the movie titles in the database in alphabetical order and store them in the cursor ---//
        Cursor cursor = database.rawQuery("SELECT "+MOVIE_TITLE+" FROM "
                +TABLE_NAME+" ORDER BY "+MOVIE_TITLE+" ASC",null);

        Log.i(LOG_TAG_MOVIE_DATABASE,"Cursor: "+cursor);

        return cursor;
    }

    public void addFavouriteMovies(Movie favouriteMovie){
        database = getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        for(int index=0; index<Movie.LIST_OF_MOVIES.size(); index++) {
            if (Movie.LIST_OF_MOVIES.get(index).equals(favouriteMovie)) {
                contentValues.put(MOVIE_IMPRESSION, favouriteMovie.getMovieImpression());
            }
        }
        database.insert(TABLE_NAME, null, contentValues);
        database.close();
    }

    public void clearAllMovieDetails(){
        database.execSQL("DELETE FROM "+TABLE_NAME+";");
    }

}
