package Home003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by m.sokolovskiy on 21.10.2016.
 */
public class HomeJ02 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] str = reader.readLine().split(" ");
        boolean sort;

        do {
            sort = false;
            for (int i = 0; i < str.length - 1; i++) {
                if (str[i].length() > str[i + 1].length()) {
                    String temp = str[i];
                    str[i] = str[i + 1];
                    str[i + 1] = temp;
                    sort = true;
                }
            }
        } while (sort);

        System.out.println("On increase: ");
        for (String number : str) {
            System.out.println(number + " - " + number.length());
        }

        System.out.println("\nOn decrease: ");
        for (int i = str.length - 1; i >= 0; i--) {
            System.out.print(str[i] + " - " + str[i].length());
        }
    }
}
