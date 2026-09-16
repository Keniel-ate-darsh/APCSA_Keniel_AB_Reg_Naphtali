import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class MovieRoulette {
    public static void main (String[] args) {
        // Declare vars
        int numPeople = 0;
        int mode = 0;
        ArrayList<Movie> catalogue = new ArrayList<>(List.of(new Movie(2025), new Movie(2026), new Movie(2027)));
        Scanner input = new Scanner(System.in);

        // Welcome
        System.out.println("Welcome, Confused Party of Movie Watchers!\n");

        // Get number of people in the group
        while (numPeople <= 0) {
            System.out.print("How many people are in your party?\n> ");
            // If the user entered an int, all cool. Else, ignore
            numPeople = (input.hasNextInt()) ? input.nextInt() : -475267;
            if (numPeople == -475267) {
                input.next();
            }
        }

        // First crossroads
        while (!(mode == 1 || mode == 2)) {
            System.out.print("Would you prefer Roulette mode (1) or Questionnaire mode(2)?\n> ");
            mode = (input.hasNextInt()) ? input.nextInt() : -475267;
            if (mode == -475267) {
                input.next();
            }
        }

        if (mode == 1) {
            // null value here to be replaced with a list once we get that added.
            getRandomMovies(catalogue);
        }
        else {
            // Collect the list of genres
            String[] genres = new String[numPeople];
            String[] validGenres = {"sci-fi", "romance", "fantasy", "horror", "comedy"};

            input.nextLine();
            for (int i = 0; i < numPeople; i++) {
                boolean isValidGenre = false;
                System.out.print("Person %d: What genre do you want to watch?\n> ".formatted(i + 1));
                String userGenre = input.nextLine();
                for (int j = 0; j < validGenres.length; j++) {
                    if (userGenre.toLowerCase() == validGenres[j]) {isValidGenre = true;}
                }
                if (isValidGenre) {genres[i] = userGenre;}
            }

            // Find the most common genre
            String mostCommon = "";
            String tiedCommon = "";
            int count = 0;
            for (int i = 0; i < genres.length; i++) {
                int tempCount = 0;
                if (!genres[i].equals(mostCommon)) {
                    for (int j = 0; j < genres.length; j++) {
                        if (genres[i] == genres[j]) {
                            tempCount++;
                        }
                    }
                    if (tempCount > count) {
                        mostCommon = genres[i];
                        tiedCommon = "";
                        count = tempCount;
                    } else if (tempCount == count) {
                        tiedCommon = genres[i];
                    }
                } else {
                    continue;
                }
            }

            // Filter by genre
            ArrayList<Movie> tempCatalogue = new ArrayList<>();
            if (!tiedCommon.equals("")) { // Only will be true if there were two most common genres
                // If this section of code is run, the count variable will be the same for both genres.
                for (int i = 0; i < catalogue.size(); i++) {
                    if (catalogue.get(i).getGenre().equals(tiedCommon) || catalogue.get(i).getGenre().equals(mostCommon)) {
                        tempCatalogue.add(catalogue.get(i));
                    }
                }
                catalogue = tempCatalogue;
            } else { // Only ran if there is only one most common genre
                // Code for filtering by one genre
                for (int i = 0; i < catalogue.size(); i++) {
                    if (catalogue.get(i).getGenre().equals(mostCommon)) {
                        tempCatalogue.add(catalogue.get(i));
                    }
                }
                catalogue = tempCatalogue;
            }

            // Next Crossroads (user input)
            mode = 0;
            while (!(mode == 1 || mode == 2 || mode == 3)) {
                System.out.print("Would you like to enter Roulette mode (1), continue the Questionnaire (2), or close the program (3)?\n> ");
                mode = (input.hasNextInt()) ? input.nextInt() : -475267;
                if (mode == -475267) {
                    input.next();
                }
            }

            if (mode == 1) {
                getRandomMovies(catalogue);
            } else if (mode == 2) {
                // Collect the list of ratings
                String[] ratings = new String[numPeople];
                String[] validRatings = {"high", "low"};

                input.nextLine();
                for (int i = 0; i < numPeople; i++) {
                    boolean isValidRating = false;
                    System.out.print("Person %d: What do you want the movie to be rated?\n> ".formatted(i + 1));
                    String userRating = input.nextLine();
                    for (int j = 0; j < validRatings.length; j++) {
                        if (userRating.toLowerCase() == validRatings[j]) {isValidRating = true;}
                    }
                    if (isValidRating) {genres[i] = userRating;}
                }

                // Find the most common rating
                mostCommon = "";
                tiedCommon = "";
                count = 0;
                for (int i = 0; i < ratings.length; i++) {
                    int tempCount = 0;
                    if (!ratings[i].equals(mostCommon)) {
                        for (int j = 0; j < ratings.length; j++) {
                            if (ratings[i] == ratings[j]) {
                                tempCount++;
                            }
                        }
                        if (tempCount > count) {
                            mostCommon = ratings[i];
                            tiedCommon = "";
                            count = tempCount;
                        } else if (tempCount == count) {
                            tiedCommon = ratings[i];
                        }
                    } else {
                        continue;
                    }
                }

                // Filter by rating
                tempCatalogue = new ArrayList<>();
                if (tiedCommon.equals("")) { // Only will be true if there was a most common rating.
                    // Code for filtering by one genre
                    for (int i = 0; i < catalogue.size(); i++) {
                        if ((mostCommon.equals("high") && catalogue.get(i).getRating() > 3 && catalogue.get(i).getRating() <= 5) || (mostCommon.equals("low") && catalogue.get(i).getRating() >= 1 && catalogue.get(i).getRating() <= 3)) {
                            tempCatalogue.add(catalogue.get(i));
                        }
                    }
                    catalogue = tempCatalogue;
                } // No else bc only two options
            }
        }



        input.close();
    }

    public static void getRandomMovies (ArrayList<Movie> list) {
        Scanner input = new Scanner(System.in);
        int movieCount = 0;

        while (movieCount <= 0) {
            System.out.print("How many movies do you want to pick?\n> ");
            movieCount = (input.hasNextInt()) ? input.nextInt() : -475267;
            if (movieCount == -475267) {
                input.next();
            }
        }

        input.close();

        if (movieCount == 1) {
            System.out.println(Roulette.chooseOne(list) + " has been chosen.");
        } else {
            Movie[] out = Roulette.chooseX(list, movieCount);
            // Very much output formatting
            if (movieCount >= list.size()) {
                for (int i = 0; i < list.size(); i++) {
                    System.out.print(out[i]);
                    if (i < list.size() - 1 && list.size() > 2) {System.out.print(", ");}
                    if (list.size() == 2 && i == 0) {System.out.print(" ");}
                    if (i == list.size() - 2) {System.out.print("and ");}
                }
            } else {
                for (int i = 0; i < movieCount; i++) {
                    System.out.print(out[i]);
                    if (i < movieCount - 1 && movieCount > 2) {System.out.print(", ");}
                    if (movieCount == 2 && i == 0) {System.out.print(" ");}
                    if (i == movieCount - 2) {System.out.print("and ");}
                }
            }
            System.out.println(" have been chosen.");
        }
    }
}