package Home003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by m.sokolovskiy on 23.10.2016.
 */
public class HomeJ07 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] str = reader.readLine().split(" ");

        for (String st : str) {
            boolean diff = false;
            if (st.length() == 1) continue;
            for (int i = 0; i < st.length(); i++) {
                for (int j = 0; j < st.length(); j++) {
                    if (i == j) continue;
                    if (st.charAt(i) == st.charAt(j)) {
                        diff = false;
                        break;
                    } else {
                        diff = true;
                    }
                }
            }
            if (diff) {
                System.out.println("Number with different figures: " + st);
                break;
            }
        }
    }
}
