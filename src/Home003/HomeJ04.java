package Home003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by m.sokolovskiy on 23.10.2016.
 */
public class HomeJ04 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] str = reader.readLine().split(" ");
        int resultIndex = 0;
        int q = 0;
        int[] quan = new int[str.length];

        for (int a = 0; a < str.length; a++) {
            for (int i = 0; i < str[a].length(); i++) {
                for (int j = 0; j < str[a].length(); j++) {
                    if (i == j) continue;
                    if (str[a].charAt(i) == str[a].charAt(j)) {
                        quan[a] += 1;
                    } else {
                        quan[a] -= 1;
                    }
                }
            }
            if (quan[a] > q) {
                q = quan[a];
                resultIndex = a;
            }
        }

        System.out.println("The first in the minimum quantity of different numbers: " + str[resultIndex]);

    }
}
