import java.util.Scanner;

public class MovieRoulette {
    public static void main (String[] args) {
        int numPeople = 0;
        int numGroup = 0;
        int mode = 0;
        String genre = "Str";
        boolean isStringCheese = false;

        Scanner input = new Scanner(System.in);
        System.out.println("Welcome Confused Party of Movie Watchers");
        System.out.println();
        while (numPeople <= 0) {
            System.out.println("How many people are in your party? ~ ");
            numPeople = (input.hasNextInt()) ? input.nextInt() : -475267;
            if (numPeople == -475267) {
                input.next();
            }
        numGroup = numPeople;
        System.out.println();
        while (mode != 1 || mode != 2) {
            System.out.println("Would you prefer Roulette mode( enter 1) or Questionaire mode( enter 2)? ~ ");
            mode = (input.nextInt());
            if (mode != 1 || mode != 2) {
                input.next();
            }
        }

        if (mode == 1) {
            getRandomMovies(null);
        }
        else {
            String[] genres = new String[numPeople]; 
            input.nextLine();
            for (int i = 0; i < numPeople; i++) {
                System.out.print("Person %d: What genre do you want to watch? ".formatted(i + 1));
                genres[i] = input.nextLine();
            }
            /*
            while (numPeople > 0) {
                System.out.println("Enter your favorite Genre from (LIST OF GENRES) ~ ");
                if (input.nextLine() instanceof String) {
                    numPeople =- 1;
                    input.next();
                }
                else {
                    System.out.println("please make sure it is a proper words");
                    input.next();
                }
            }*/
            
        }



        input.close();
    }
    }

    public static void getRandomMovies (Movie[] list) {
        
    }
}