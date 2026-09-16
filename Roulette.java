import java.util.ArrayList;

public class Roulette {
    public static Movie chooseOne (ArrayList<Movie> list) {
        return list.get((int)(Math.random() * list.size()));
    }

    public static Movie[] chooseX (ArrayList<Movie> list, int x) {
        int j;
        ArrayList<Movie> list2 = new ArrayList<>();
        if( x >= list.size()){
            return list.toArray(new Movie[0]);
        }
        else {
            for(int i = 0; i < x; i ++){
                j = (int)(Math.random() * list.size());
                list2.add(list.get(j));
                list.remove(j);
            }
            Movie[] out = list2.toArray(new Movie[0]);
            return out;
        }
    }
}