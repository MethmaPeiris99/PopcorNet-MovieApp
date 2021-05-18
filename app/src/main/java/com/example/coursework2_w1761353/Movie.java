package com.example.coursework2_w1761353;

import java.util.ArrayList;
import java.util.List;

public class Movie {

    //------- Declare instance variables of Movie class -------//
    private String movieTitle;
    private int movieYear;
    private String movieDirector;
    private String movieActorList;
    private int movieRating;
    private String movieReview;
    private int movieImpression;

    //------- Initialize constant variables of Movie class -------//
    public static final int FAVOURITE_MOVIE_IMPRESSION_VALUE = 1;
    public static final int NON_FAVOURITE_MOVIE_IMPRESSION_VALUE = 0;
    public static final List<Movie> LIST_OF_MOVIES = new ArrayList<>();

    //----------------- Initialize class variables -----------------//
    public static List<Movie> listOfFavouriteMovies = new ArrayList<>(); //Array list used to store favourite movies

    //------- Constructors of Movie class -------//
    public Movie(){

    }

    public Movie(String inputMovieTitle,int inputMovieYear,String inputMovieDirector,
                 String inputMovieActorList,int inputMovieRating,String inputMovieReview){
        this.movieTitle = inputMovieTitle;
        this.movieYear = inputMovieYear;
        this.movieDirector = inputMovieDirector;
        this.movieActorList = inputMovieActorList;
        this.movieRating = inputMovieRating;
        this.movieReview = inputMovieReview;
        this.movieImpression = NON_FAVOURITE_MOVIE_IMPRESSION_VALUE;
    }

    //------------- Getter methods of Movie class -------------//
    public String getMovieTitle() {
        return movieTitle;
    }

    public int getMovieYear() {
        return movieYear;
    }

    public String getMovieDirector() {
        return movieDirector;
    }

    public String getMovieActorList() {
        return movieActorList;
    }

    public int getMovieRating() {
        return movieRating;
    }

    public String getMovieReview() {
        return movieReview;
    }

    public int getMovieImpression(){
        return movieImpression;
    }

    //------------- Setter methods of Movie class -------------//
    public void setMovieTitle(String inputMovieTitle) {
        this.movieTitle = inputMovieTitle;
    }

    public void setMovieYear(int inputMovieYear) {
        this.movieYear = inputMovieYear;
    }

    public void setMovieDirector(String inputMovieDirector) {
        this.movieDirector = inputMovieDirector;
    }

    public void setMovieActorList(String inputMovieActorList) {
        this.movieActorList = inputMovieActorList;
    }

    public void setMovieRating(int inputMovieRating) {
        this.movieRating = inputMovieRating;
    }

    public void setMovieReview(String inputMovieReview) {
        this.movieReview = inputMovieReview;
    }

    public void setMovieImpression(int inputOfMovieImpression){
        this.movieImpression = inputOfMovieImpression;
    }

    //------------- toString() method of Movie class -------------//
    @Override
    public String toString() {
        return "Movie{" +
                "movieTitle='" + movieTitle + '\'' +
                ", movieYear=" + movieYear +
                ", movieDirector='" + movieDirector + '\'' +
                ", movieActorList='" + movieActorList + '\'' +
                ", movieRating=" + movieRating +
                ", movieReview='" + movieReview + '\'' +
                ", movieImpression=" + movieImpression +
                '}';
    }
}
