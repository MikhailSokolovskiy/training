package Home001;

import java.util.stream.IntStream;

/**
 * Created by m.sokolovskiy on 11.10.2016.
 */
public class HomeJ01 {
    public static void main(String[] args) {
//        IntStream.rangeClosed('A', 'Z')
//                .mapToObj(c -> "" + (char) c)
//                .forEach(System.out::println);

        char a = 'A';
        do {
            System.out.print((char) a + "" + ((char) (a + 32)) + " ");
            a++;
        } while (a <= 'Z');

        IntStream.range(65, 123) //range for ASCII table
                .filter(n -> n < 91 || n > 96) // filter for exclude not alphabetic letters
                .forEach(n -> System.out.print((char)n + " ")); // print
    }
}
