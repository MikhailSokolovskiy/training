package Home003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by m.sokolovskiy on 23.10.2016.
 */
public class HomeJ06 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] str = reader.readLine().split(" ");

        for (String st : str) {
            boolean asc = true;
            for (int i = 0; i < st.length() - 1; i++) {
                if ((int) st.charAt(i) + 1 != (int) st.charAt(i + 1)) {
                    asc = false;
                    break;
                }
            }
            if (asc) {
                System.out.println("Number in which figures go in ascending order: " + st);
                break;
            }
        }
    }
}
