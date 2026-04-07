package LabMethodsAndDb;

import java.util.ArrayList;

public class MovieRating {
    public enum MovieRatings {
        G, PG, PG13, R;
    }

    public static void addRating(ArrayList<MovieRatings> ratings, MovieRatings rating) {
        ratings.add(rating);
    }

    public static void showRatings(ArrayList<MovieRatings> ratings) {
        for (MovieRatings rating : ratings) {
            System.out.println(rating);
        }
    }

    public static void main(String[] args) {
        ArrayList<MovieRatings> ratings = new ArrayList<>();
        addRating(ratings, MovieRatings.PG);
        addRating(ratings, MovieRatings.R);
        addRating(ratings, MovieRatings.G);
        addRating(ratings, MovieRatings.PG13);
        showRatings(ratings);
    }
}