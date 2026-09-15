import java.util.Scanner;

public class MovieRoulette {
    public static void main (String[] args) {
        // Declare vars
        int numPeople = 0;
        int mode = 0;
        //boolean isStringCheese = false;
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
        while (mode != 1 || mode != 2) {
            System.out.print("Would you prefer Roulette mode (1) or Questionnaire mode(2)?\n> ");
            mode = (input.hasNextInt()) ? input.nextInt() : -475267;
            if (mode == -475267) {
                input.next();
            }
        }

        if (mode == 1) {
            // null value here to be replaced with a list once we get that added.
            getRandomMovies(null);
        }
        else {
            // Collect the list of genres
            String[] genres = new String[numPeople];
            String[] validGenres = {};

            input.nextLine();
            for (int i = 0; i < numPeople; i++) {
                boolean isValidGenre = false;
                System.out.print("Person %d: What genre do you want to watch? ".formatted(i + 1));
                String userGenre = input.nextLine();
                for (int j = 0; j < validGenres.length; j++) {
                    if (userGenre.toLowerCase() == validGenres[j]) {isValidGenre = true;}
                }
                if (isValidGenre) {genres[i] = userGenre;}
            }
            // From here we need to determine most common genre.            
        }



        input.close();
    }

    public static void getRandomMovies (Movie[] list) {
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
            if (movieCount >= list.length) {
                for (int i = 0; i < list.length; i++) {
                    System.out.print(out[i]);
                    if (i < list.length - 1 && list.length > 2) {System.out.print(", ");}
                    if (list.length == 2 && i == 0) {System.out.print(" ");}
                    if (i == list.length - 2) {System.out.print("and ");}
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