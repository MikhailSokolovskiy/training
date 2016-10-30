package Home002;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by m.sokolovskiy on 23.10.2016.
 */
public class HomeJ03 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] str = reader.readLine().split(" ");
        int middle = 0;
        String lesMiddle = "", moMiddle = "";

        for (String st : str) {
            middle += st.length();
        }
        middle /= str.length;

        for (String number : str) {
            if (number.length() < middle) {
                lesMiddle += number + " - " + number.length() + "\n";
            } else if (number.length() > middle){
                moMiddle += number + " - " + number.length() + "\n";
            }
        }
        System.out.printf("Average length of all figures: %s\n", middle);
        System.out.printf("Number there is less average length:\n%s\n", lesMiddle);
        System.out.printf("Number there is more average length:\n%s", moMiddle);

    }

}
