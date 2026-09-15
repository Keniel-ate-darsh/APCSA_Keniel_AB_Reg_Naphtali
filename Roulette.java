import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Roulette {
    public static Movie chooseOne (Movie[] list) {
        return list[(int)(Math.random() * list.length)];
    }

    public static Movie[] chooseX (Movie[] list, int x) {
        int j;
        List<Movie> editList = new ArrayList<>(Arrays.asList(list));
        ArrayList<Movie> list2 = new ArrayList<>();
        if( x >= list.length){
            return list;
        }
        else {
            for(int i = 0; i < x; i ++){
                j = (int)(Math.random() * editList.length);
                list2.add(list[j]);
                editList.remove(j);
            }
            Movie[] out = list2.toArray(new Movie[0]);
            return out;
        }
    }
}