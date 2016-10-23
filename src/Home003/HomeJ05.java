package Home003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by m.sokolovskiy on 23.10.2016.
 */
public class HomeJ05 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] str = reader.readLine().split(" ");
        String res = "";

        for (String st : str) {
            if (Integer.parseInt(st) % 2 == 0) {
                int ch = 0;
                int nch = 0;
                for (int i = 0; i < st.length(); i++) {
                    if (st.charAt(i) % 2 == 0) {
                        ch += 1;
                    } else {
                        nch += 1;
                    }
                }
                if (ch == nch) {
                    res += st + " ";
                }
            }
        }
        System.out.printf("Even with equal quantity even and not even:\n%s", res);
    }
}
