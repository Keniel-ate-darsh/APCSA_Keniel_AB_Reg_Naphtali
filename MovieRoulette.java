/*
* MovieRoulette.java
* Authors: Keniel, Reg, AB, Naphtali
*/

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class MovieRoulette {
    public static void main (String[] args) {
        // Declare vars
        int numPeople = 0;
        int mode = 0;
        ArrayList<Movie> catalogue = new ArrayList<>(List.of( // Parodies to avoid copyright
            new Movie("Yacht", "romance", 1997, 3.8, 194),
            new Movie("Ugly and the Small", "romance", 2003, 2.0, 73),
            new Movie("Romeo and Julio", "romance", 2025, 2.4, 82),
            new Movie("The Prince Husband", "romance", 1987, 4.8, 98),
            new Movie("Tree Genius", "romance", 1999, 3.2, 154),
            new Movie("Normal Poor European", "romance", 1820, 1.2, 212),
            new Movie("Star Warriors", "sci-fi", 1977, 3.4, 98),
            new Movie("Project Fail Harry", "sci-fi", 2026, 2.0, 132),
            new Movie("The Array", "sci-fi", 2015, 4.3, 113),
            new Movie("Cretaceous Land", "sci-fi", 1993, 3.9, 134),
            new Movie("Lizard vs. Monkey", "sci-fi", 1970, 4.6, 140),
            new Movie("A Loud Evict", "sci-fi", 2008, 1.4, 90),
            new Movie("Caves and Lizards", "fantasy", 2023, 2.2, 128),
            new Movie("Hairy the Potman", "fantasy", 2001, 3.5, 152),
            new Movie("The Avenged", "fantasy", 2013, 4.2, 90),
            new Movie("Tenant Good", "fantasy", 2026, 5.0, 100),
            new Movie("King of the Bracelets", "fantasy", 2007, 3.9, 212),
            new Movie("Lesbian Space Princess", "fantasy", 2024, 1.0, 87),
            new Movie("Shout", "horror", 1996, 2.1, 87),
            new Movie("Dream before Easter", "horror", 2008, 4.0, 109),
            new Movie("Monday", "horror", 2022, 3.3, 137),
            new Movie("I.T.", "horror", 2020, 2.8, 110),
            new Movie("A Loud Area", "horror", 2023, 1.8, 147),
            new Movie("The Whitening", "horror", 2022, 3.1, 97),
            new Movie("KAR3N", "horror", 2022, 3.0, 102),
            new Movie("Green Guy", "comedy", 2001, 3.6, 124),
            new Movie("Mr. Montanus and the Holy Quail", "comedy", 1976, 4.9, 121),
            new Movie("Livepool", "comedy", 2016, 1.3, 142),
            new Movie("Slow Minute", "comedy", 1998, 2.7, 98),
            new Movie("Skypig Night", "comedy", 1993, 3.7, 101),
            new Movie("The Resurrector", "action", 1984, 4.1, 141),
            new Movie("Sitting Woman", "action", 1996, 2.1, 101),
            new Movie("Bill Candle", "action", 2014, 3.6, 101),
            new Movie("StartGame", "action", 2024, 4.6, 185),
            new Movie("The Rest of Them", "action", 2014, 2.8, 152),
            new Movie("The Satanson", "action", 1972, 4.5, 175),
            new Movie("El Increíble Huk", "action", 2008, 3.3, 112),
            new Movie("Tarantula-man: Into the Tarantulaverse", "action", 2018, 3.6, 117),
            new Movie("Ohio John and the Found Boat", "action", 1981, 4.2, 115),
            new Movie("Tungsten Man", "action", 2002, 3.9, 126),
            new Movie("The Slow and the Happy", "action", 2001, 3.4, 106)
        ));
        Scanner input = new Scanner(System.in);

        // Welcome
        System.out.println("Welcome, Confused Party of Movie Watchers!");

        // Get number of people in the group
        while (numPeople <= 0 || numPeople > 8) {
            System.out.print("How many people are in your party (max of 8)?\n> ");
            // If the user entered an int, all cool. Else, ignore
            if (input.hasNextInt()) {
                numPeople = input.nextInt();
            } else {
                input.next();
            }
        }

        // First crossroads
        while (!(mode == 1 || mode == 2)) {
            System.out.print("\nWould you prefer Roulette mode (1) or Questionnaire mode(2)?\n> ");
            if (input.hasNextInt()) { // Simple input validation
                mode = input.nextInt();
            } else {
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
            String[] validGenres = {"sci-fi", "romance", "fantasy", "horror", "comedy", "action"};

            input.nextLine();
            for (int i = 0; i < numPeople; i++) {
                boolean isValidGenre = false;
                while (!isValidGenre) { // as long as they don't enter a valid genre, it repeats.
                    System.out.print("\nPerson %d, What genre do you want to watch (out of sci-fi, romance, comedy, fantasy, action, and horror)?\n> ".formatted(i + 1));
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
            for (int i = 0; i < genres.length; i++) { // loops through the list
                int tempCount = 0;
                if (!genres[i].equals(mostCommon)) {
                    for (int j = 0; j < genres.length; j++) { // compares the item to each other item, itself included (only 1 occurence -> tempCount of 1)
                        //System.out.println(i + " " + j + " " + genres[i] + " " + genres[j]);
                        if (genres[i].equals(genres[j])) {
                            tempCount++;
                        }
                    }
                    if (tempCount > count) { // if the current item is more common
                        mostCommon = genres[i];
                        tiedCommon = "";
                        count = tempCount;
                    } else if (tempCount == count) { // oh its tied? neat
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
            for (int i = 0; i < catalogue.size(); i++) { // This is a lot. Effectively it just formats the list of movies into a pretty string.
                System.out.print(catalogue.get(i)); // The movie
                if (i < catalogue.size() - 1 && catalogue.size() > 2) {System.out.print(", ");} // If it's in the list and not the last item (first*, *second*, *and last.)
                if (catalogue.size() == 2 && i == 0) {System.out.print(" ");} // if only two items, no need for a comma (first* *and last.)
                if (i == catalogue.size() - 2) {System.out.print("and ");} // if the second to last item, say and (first, second to last, *and *last.)
                if (i == catalogue.size() - 1) {System.out.println(".");} // put a period at the end (first, second, and last.)
            } // Basically identical at the end of the program. in getRandomMovies(), there is no period because its in the middle of the sentence.

            mode = 0;
            while (!(mode == 1 || mode == 2 || mode == 3)) {
                System.out.print("\nWould you like to enter Roulette mode (1), continue the Questionnaire (2), or close the program (3)?\n> ");
                if (input.hasNextInt()) { // More input validation
                    mode = input.nextInt();
                } else {
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
                        System.out.print("\nPerson %d, what do you want the movie to be rated (out of high, average, and low)?\n> ".formatted(i + 1));
                        String userRating = input.nextLine();
                        for (int j = 0; j < validRatings.length; j++) { // Making sure the user entered a valid rating. and yes, it is a string representing a range, not a number.
                            if (userRating.toLowerCase().equals(validRatings[j])) {isValidRating = true;}
                        }
                        if (isValidRating) {ratings[i] = userRating;}
                    }
                }

                // Find the most common rating
                mostCommon = "";
                tiedCommon = "";
                count = 0; // same as with genres but some different names
                for (int i = 0; i < ratings.length; i++) {
                    int tempCount = 0;
                    if (!ratings[i].equals(mostCommon)) {
                        for (int j = 0; j < ratings.length; j++) {
                            if (ratings[i].equals(ratings[j])) {
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

                System.out.println(mostCommon + " " + tiedCommon);
                // Filter by rating
                tempCatalogue = new ArrayList<>();
                if (!tiedCommon.equals("")) { // Only will be true if there were two most common ratings
                    // If this section of code is run, the count variable will be the same for both ratings.
                    // Since you're probably too lazy to read the whole condition, here's what it says in a nutshell.
                    // "high" -> 3.8 to 5.0 stars; "average" -> 2.3 to 3.7 stars; "low" -> 1.0 to 2.2 stars
                    for (int i = 0; i < catalogue.size(); i++) {
                        if ((mostCommon.equals("high") && catalogue.get(i).getRating() >= 3.75 && catalogue.get(i).getRating() <= 5) || (mostCommon.equals("low") && catalogue.get(i).getRating() >= 1 && catalogue.get(i).getRating() <= 2.25) || (mostCommon.equals("average") && catalogue.get(i).getRating() >= 2.25 && catalogue.get(i).getRating() <= 3.75)) {
                            tempCatalogue.add(catalogue.get(i));
                        }
                        if ((tiedCommon.equals("high") && catalogue.get(i).getRating() >= 3.75 && catalogue.get(i).getRating() <= 5) || (tiedCommon.equals("low") && catalogue.get(i).getRating() >= 1 && catalogue.get(i).getRating() <= 2.25) || (tiedCommon.equals("average") && catalogue.get(i).getRating() >= 2.25 && catalogue.get(i).getRating() <= 3.75)) {
                            tempCatalogue.add(catalogue.get(i));
                        }
                    }
                    catalogue = tempCatalogue;
                } else { // Only ran if there is only one most common rating
                    // Code for filtering by one rating
                    for (int i = 0; i < catalogue.size(); i++) {
                        if ((mostCommon.equals("high") && catalogue.get(i).getRating() >= 3.75 && catalogue.get(i).getRating() <= 5) || (mostCommon.equals("low") && catalogue.get(i).getRating() >= 1 && catalogue.get(i).getRating() <= 2.25) || (mostCommon.equals("average") && catalogue.get(i).getRating() >= 2.25 && catalogue.get(i).getRating() <= 3.75)) {
                            tempCatalogue.add(catalogue.get(i));
                        }
                    }
                    catalogue = tempCatalogue;
                }

                if (catalogue.size() == 1) { // Output the final list of movies. v Singular
                    System.out.println("The movie you have selected is " + catalogue.get(0) + ".");
                } else { // v Plural
                    System.out.print("\nThe movies you have selected are ");
                    for (int i = 0; i < catalogue.size(); i++) {
                        System.out.print(catalogue.get(i));
                        if (i < catalogue.size() - 1 && catalogue.size() > 2) {System.out.print(", ");}
                        if (catalogue.size() == 2 && i == 0) {System.out.print(" ");}
                        if (i == catalogue.size() - 2) {System.out.print("and ");}
                        if (i == catalogue.size() - 1) {System.out.println(".");}
                    }
                }
            } // Note that this ends the else if (mode == 2) after the genres have been collected.
        } // There is no else because the code for exiting the program happens once the conditions are done working.

        input.close(); // Exit the program
        System.out.println("Enjoy your movie!");
    }

    public static void getRandomMovies (ArrayList<Movie> list) {
        // This sends nothing back because after executing the program exits because there is no code afterward.
        Scanner input = new Scanner(System.in);
        int movieCount = 0;

        while (movieCount <= 0) {
            System.out.print("\nHow many movies do you want to pick?\n> ");
            if (input.hasNextInt()) {
                movieCount = input.nextInt();
            } else { // wow i love input validation
                input.next();
            }
        }

        input.close(); // we're done with this Scanner.

        if (movieCount == 1) { // Display the output
            System.out.println("\n" + Roulette.chooseOne(list) + " has been chosen.");
        } else {
            Movie[] out = Roulette.chooseX(list, movieCount);
            // Very much output formatting. explained in detail above.
            System.out.println();
            for (int i = 0; i < out.length; i++) {
                System.out.print(out[i]);
                if (i < out.length - 1 && out.length > 2) {System.out.print(", ");}
                if (out.length == 2 && i == 0) {System.out.print(" ");}
                if (i == out.length - 2) {System.out.print("and ");}
            }
            System.out.println(" have been chosen."); // This is the reason there is no fourth if () {} for a period afterwards.
        }
    }
}