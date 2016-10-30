package Home001;

import java.io.IOException;


/**
 * Created by m.sokolovskiy on 13.10.2016.
 */
public class HomeJ03 {
    public static void main(String[] args) throws IOException {
        int quan = 10;

        for (int i = 0; i <= quan; i++) {
            System.out.println((int) (Math.random() * 100));
        }
        for (int i = 0; i <= quan; i++) {
            System.out.print((int) (Math.random() * 100) + " ");
        }
    }
}
