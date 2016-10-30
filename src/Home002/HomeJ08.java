package Home002;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Math.pow;

/**
 * Created by m.sokolovskiy on 23.10.2016.
 */
public class HomeJ08 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int mat = Integer.parseInt(reader.readLine());
        int i = 1;

        do {
            System.out.print(i + " ");
            if (i % mat == 0) {
                System.out.println();
            }
            i++;
        } while (i <= pow(mat, 2));
    }
}
