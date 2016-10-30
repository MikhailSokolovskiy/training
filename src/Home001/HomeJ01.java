package Home001;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by m.sokolovskiy on 13.10.2016.
 */
public class HomeJ01 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.printf("Hello, %s.", reader.readLine());
    }
}
