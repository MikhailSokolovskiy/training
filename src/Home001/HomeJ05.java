package Home001;

import java.io.IOException;


/**
 * Created by m.sokolovskiy on 13.10.2016.
 */
public class HomeJ05 {
    public static void main(String[] args) throws IOException {
        int sum = Integer.parseInt(args[0]);
        int mult = Integer.parseInt(args[0]);

        for (int i = 1; i <= args.length - 1; i++) {
            sum += Integer.parseInt(args[i]);
            mult *= Integer.parseInt(args[i]);
        }
        System.out.printf("Amount  = %d\nMultiplication = %d", sum, mult);
    }
}
