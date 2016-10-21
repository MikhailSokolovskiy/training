package Home002;

import java.io.IOException;


/**
 * Created by m.sokolovskiy on 13.10.2016.
 */
public class HomeJ02 {
    public static void main(String[] args) throws IOException {
        for (int i = args.length - 1; i >= 0; i--) {
            System.out.print(args[i] + " ");
        }
    }
}
