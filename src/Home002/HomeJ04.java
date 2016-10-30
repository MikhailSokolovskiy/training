package Home002;

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
        int res2 = -50;

        for (int a = 0; a < str.length; a++) {
            int res1 = 0;
            for (int i = 0; i < str[a].length(); i++) {
                for (int j = 0; j < str[a].length(); j++) {
                    if (str[a].charAt(i) != str[a].charAt(j)) {
                        res1 -= 1;
                    }
                    res1 -= 1;
                }
            }
            //System.out.printf("%s/%s - %s - %s\n", str[a], str[a].length(), res1, res2);
            if (res1 > res2) {
                res2 = res1;
                resultIndex = a;
            }
        }

        System.out.println("The first in the minimum quantity of different numbers: " + str[resultIndex]);

    }
}
