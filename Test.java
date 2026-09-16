// This file exists solely to test other files.

public class Test {
    public static void main(String[] args) {
        String[] genres = {"1", "1", "2", "2"};
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
        System.out.println(mostCommon + " | " + tiedCommon);
    }

}