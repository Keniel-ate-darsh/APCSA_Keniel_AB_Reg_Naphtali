import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class MovieRoulette {
    public static void main (String[] args) {
        // Declare vars
        int numPeople = 0;
        int mode = 0;
        ArrayList<Movie> catalogue = new ArrayList<>(List.of(
            new Movie("Yacht", "romance", 1997, 3.8, 194),
            new Movie("Ugly and the Small", "romance", 2003, 2.0, 73),
            new Movie("Romeo and Julio", "romance", 2025, 2.3, 82),
            new Movie("Star Warriors", "sci-fi", 1977, 3.4, 98),
            new Movie("Project Fail Harry", "sci-fi", 2026, 2.0, 132),
            new Movie("The Array", "sci-fi", 2015, 4.3, 113),
            new Movie("Caves and Lizards", "fantasy", 2023, 2.2, 128),
            new Movie("Hairy the Potman", "fantasy", 2001, 3.5, 152),
            new Movie("The Avenged", "fantasy", 2013, 4.2, 90),
            new Movie("Shout", "horror", 1996, 2.1, 87),
            new Movie("Dream before Easter", "horror", 2008, 4.0, 109),
            new Movie("Monday", "horror", 2022, 3.3, 137),
            new Movie("Green Guy", "comedy", 2001, 3.6, 124),
            new Movie("Mr. Montanus and the Holy Quail", "comedy", 1976, 4.9, 121),
            new Movie("Livepool", "comedy", 2016, 1.3, 142)
        ));
        Scanner input = new Scanner(System.in);

        // Welcome
        System.out.println("Welcome, Confused Party of Movie Watchers!");

        // Get number of people in the group
        while (numPeople <= 0 || numPeople > 8) {
            System.out.print("How many people are in your party (max of 8)?\n> ");
            // If the user entered an int, all cool. Else, ignore
            numPeople = (input.hasNextInt()) ? input.nextInt() : -475267;
            if (numPeople == -475267) {
                input.next();
            }
        }

        // First crossroads
        while (!(mode == 1 || mode == 2)) {
            System.out.print("\nWould you prefer Roulette mode (1) or Questionnaire mode(2)?\n> ");
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
                while (!isValidGenre) {
                    System.out.print("\nPerson %d: What genre do you want to watch (out of sci-fi, romance, comedy, fantasy, and horror)?\n> ".formatted(i + 1));
                    String userGenre = input.nextLine();
                    for (int j = 0; j < validGenres.length; j++) {
                        if (userGenre.toLowerCase().equals(validGenres[j])) {isValidGenre = true;}
                        //System.out.println(userGenre + " | " + validGenres[j] + " | " + isValidGenre);
                    }
                    if (isValidGenre) {genres[i] = userGenre;}
                }
            }

            // Find the most common genre
            String mostCommon = "";
            String tiedCommon = "";
            int count = 0;
            for (int i = 0; i < genres.length; i++) {
                int tempCount = 0;
                if (!genres[i].equals(mostCommon)) {
                    for (int j = 0; j < genres.length; j++) {
                        //System.out.println(i + " " + j + " " + genres[i] + " " + genres[j]);
                        if (genres[i].equals(genres[j])) {
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
                //System.out.println(mostCommon + " " + tiedCommon + " " + count + " " + tempCount);
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
            // Display movies
            System.out.print("\nThe current list of movies is ");
            for (int i = 0; i < catalogue.size(); i++) {
                System.out.print(catalogue.get(i));
                if (i < catalogue.size() - 1 && catalogue.size() > 2) {System.out.print(", ");}
                if (catalogue.size() == 2 && i == 0) {System.out.print(" ");}
                if (i == catalogue.size() - 2) {System.out.print("and ");}
            }

            mode = 0;
            while (!(mode == 1 || mode == 2 || mode == 3)) {
                System.out.print("\nWould you like to enter Roulette mode (1), continue the Questionnaire (2), or close the program (3)?\n> ");
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
                String[] validRatings = {"high", "average", "low"};

                input.nextLine();
                for (int i = 0; i < numPeople; i++) {
                    boolean isValidRating = false;
                    while (!isValidRating) {
                        System.out.print("Person %d: What do you want the movie to be rated (out of high, average, and low)?\n> ".formatted(i + 1));
                        String userRating = input.nextLine();
                        for (int j = 0; j < validRatings.length; j++) {
                            if (userRating.toLowerCase().equals(validRatings[j])) {isValidRating = true;}
                        }
                        if (isValidRating) {ratings[i] = userRating;}
                    }
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
                if (!tiedCommon.equals("")) { // Only will be true if there were two most common ratings
                    // If this section of code is run, the count variable will be the same for both ratings.
                    for (int i = 0; i < catalogue.size(); i++) {
                        if ((mostCommon.equals("high") && catalogue.get(i).getRating() >= 3.75 && catalogue.get(i).getRating() <= 5) || (mostCommon.equals("low") && catalogue.get(i).getRating() >= 1 && catalogue.get(i).getRating() <= 2.25) || (mostCommon.equals("average") && catalogue.get(i).getRating() >= 2.25 && catalogue.get(i).getRating() <= 3.75)) {
                            tempCatalogue.add(catalogue.get(i));
                        }
                    }
                    catalogue = tempCatalogue;
                } else { // Only ran if there is only one most common genre
                    // Code for filtering by one genre
                    for (int i = 0; i < catalogue.size(); i++) {
                        if ((mostCommon.equals("high") && catalogue.get(i).getRating() >= 3.75 && catalogue.get(i).getRating() <= 5) || (mostCommon.equals("low") && catalogue.get(i).getRating() >= 1 && catalogue.get(i).getRating() <= 2.25) || (mostCommon.equals("average") && catalogue.get(i).getRating() >= 2.25 && catalogue.get(i).getRating() <= 3.75)) {
                            tempCatalogue.add(catalogue.get(i));
                        }
                    }
                    catalogue = tempCatalogue;
                }

                // Final section.
                // Display list
                System.out.print("\nThe current list of movies is ");
                for (int i = 0; i < catalogue.size(); i++) {
                    System.out.print(catalogue.get(i));
                    if (i < catalogue.size() - 1 && catalogue.size() > 2) {System.out.print(", ");}
                    if (catalogue.size() == 2 && i == 0) {System.out.print(" ");}
                    if (i == catalogue.size() - 2) {System.out.print("and ");}
                }

                // Final input
                System.out.print("Do you want to randomly narrow the list (y/n)?\n> ");
                if (Character.toLowerCase(input.next().charAt(0)) == 'y') {
                    getRandomMovies(catalogue);
                }
            }
        }

        input.close();
        System.out.println("Enjoy your movie!");
    }

    public static void getRandomMovies (ArrayList<Movie> list) {
        Scanner input = new Scanner(System.in);
        int movieCount = 0;

        while (movieCount <= 0) {
            System.out.print("\nHow many movies do you want to pick?\n> ");
            movieCount = (input.hasNextInt()) ? input.nextInt() : -475267;
            if (movieCount == -475267) {
                input.next();
            }
        }

        input.close();

        if (movieCount == 1) {
            System.out.println("\n" + Roulette.chooseOne(list) + " has been chosen.");
        } else {
            Movie[] out = Roulette.chooseX(list, movieCount);
            // Very much output formatting
            System.out.println();
            for (int i = 0; i < out.length; i++) {
                System.out.print(out[i]);
                if (i < out.length - 1 && out.length > 2) {System.out.print(", ");}
                if (out.length == 2 && i == 0) {System.out.print(" ");}
                if (i == out.length - 2) {System.out.print("and ");}
            }
            System.out.println(" have been chosen.");
        }
    }
}