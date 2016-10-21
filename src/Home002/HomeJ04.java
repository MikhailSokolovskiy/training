package Home002;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * Created by m.sokolovskiy on 13.10.2016.
 */
public class HomeJ04 {
    public static void main(String[] args) throws IOException {
        String passw = "password";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (!reader.readLine().equals(passw)) {
            System.out.println("Access is denied!!!");
        }
        System.out.println("Access is granted :)");

    }
}
