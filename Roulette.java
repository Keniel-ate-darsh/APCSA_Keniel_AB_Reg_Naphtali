/*
* Roulette.java
* Authors: Keniel, Naphtali
*/

import java.util.ArrayList;

public class Roulette {
    public static Movie chooseOne (ArrayList<Movie> list) {
        return list.get((int)(Math.random() * list.size())); // Pick a random movie and return it
    }

    public static Movie[] chooseX (ArrayList<Movie> list, int x) {
        int j;
        ArrayList<Movie> list2 = new ArrayList<>();
        if(x >= list.size() || x <= 0){
            // If the provided # of movies to return is >= the length of the list, no point in randoming and having stuff be wierd
            // Also if the provided # of movies to return is below 0
            return list.toArray(new Movie[0]);
        }
        else {
            for(int i = 0; i < x; i ++){
                // Select a movie and move it into the new list
                j = (int)(Math.random() * list.size());
                list2.add(list.get(j));
                list.remove(j);
            }
            Movie[] out = list2.toArray(new Movie[0]);
            return out;
        }
    }
}