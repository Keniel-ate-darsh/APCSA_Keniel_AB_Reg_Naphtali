/*
* Movie.java
* Author: Naphtali
*/

public class Movie {
    // Attributes
    private String title;
    private String genre;
    private int year;
    private double rating;
    private int runtime;

    // Constructor
    public Movie (int year) {
        // For easier testing
        this("Hello world", "", year, 4.5, 120);
    }

    public Movie (String title, String genre, int year, double rating, int runtime) {
        this.genre = genre;
        this.year = year;
        this.runtime = runtime;
        this.rating = rating;
        this.title = title;
    }

    // Accesssors and Mutators
    public String getGenre () {
        return this.genre;
    }

    public void setGenre (String genre) {
        this.genre = genre;
    }

    public int getYear () {
        return this.year;
    }

    public void setYear (int year) {
        this.year = year;
    }

    public int getRuntime () {
        return this.runtime;
    }

    public void setRuntime (int runtime) {
        this.runtime = runtime;
    }

    public double getRating () {
        return this.rating;
    }

    public void setRating (double rating) {
        this.rating = rating;
    }

    public String getTitle () {
        return this.title;
    }

    public void setTitle (String title) {
        this.title = title;
    }

    // Other
    public String toString () {
        return "%s (%d, %s) %.1f★".formatted(this.title, this.year, this.getRuntimeString(), this.rating);
    }

    public String getRuntimeString () {
        if (this.runtime % 60 == 0) {
            return "%dh".formatted(this.runtime / 60);
        } else {
            return "%dh %dm".formatted(this.runtime / 60, this.runtime % 60);
        }
    }
}