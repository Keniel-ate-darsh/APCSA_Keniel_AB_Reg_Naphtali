public class Movie {
    // Attributes
    private String genre;
    private int year;
    private int runtime;
    private double rating;
    private String title;

    // Constructor
    public Movie (String genre, int year, int runtime, double rating, String title) {
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
        return "%s (%d, %s) %f★".formatted(this.title, this.year, this.getRuntimeString(), this.rating);
    }

    public String getRuntimeString () {
        return "%dh %dm".formatted(this.runtime / 60, this.runtime % 60);
    }
}