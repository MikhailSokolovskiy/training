package Home003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by m.sokolovskiy on 21.10.2016.
 */
public class HomeJ01 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] str = reader.readLine().split(" ");
        int min = 0, max = 0;

        for (int i = 0; i < str.length; i++) {
            if (min == 0) {
                min = i;
            } else if (str[i].length() <= str[min].length()) {
                min = i;
            }
            if (str[i].length() > str[max].length()) {
                max = i;
            }
        }
        System.out.printf("Length of numbers:\n   minNumLen: %s (Len %s)\n   maxNumLen: %s (Len %s)", str[min], str[min].length(), str[max], str[max].length());
    }
}
