package Home001;

/**
 * Created by m.sokolovskiy on 11.10.2016.
 */
public class HomeJ01 {
    public static void main(String[] args) {
        char a = 'A';
        do {
            System.out.print(a + "" + ((char) (a + 32)) + " ");
            a++;
        } while (a <= 'Z');
   }
}
