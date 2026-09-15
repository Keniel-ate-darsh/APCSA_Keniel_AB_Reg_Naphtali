// This file exists solely to test other files.

public class Test {
    public static void main(String[] args) {
        Movie[] testArray = {new Movie(1), new Movie(2), new Movie(3)};

        MovieRoulette.getRandomMovies(testArray);
    }
}