package com.example.recyclerbutton;

public class MyMovieData {


    private String movieName;
    private String movieDate;
    private Integer movieImage;
    private String color;

    public MyMovieData(String movieName, String movieDate, Integer movieImage, String color) {
        this.movieName = movieName;
        this.movieDate = movieDate;
        this.movieImage = movieImage;
        this.color = color;
    }

    public MyMovieData(String name, String number, int avatar) {
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieDate() {
        return movieDate;
    }

    public void setMovieDate(String movieDate) {
        this.movieDate = movieDate;
    }

    public Integer getMovieImage() {
        return movieImage;
    }

    public void setMovieImage(Integer movieImage) {
        this.movieImage = movieImage;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
