package Home004;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by m.sokolovskiy on 28.10.2016.
 */
public class CompatibilityTest {
    public static void main(String[] args) throws IOException {
        Human h1 = newHuman();
        Human h2 = newHuman();
        //Human h2 = new Men("q1", "w1", 11, 12);
        //Human h1 = new Woman("q2", "w2", 12, 13);
        System.out.println(h1);
        System.out.println(h2);
        Human child = testCompatibility(h1, h2);
        System.out.println("Result relationship: " + (child == null ? "Nothing came ... scattered" : child));
    }

    static Human newHuman() throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input sex (men or women):");
        boolean sex = r.readLine().equals("men") ? true : false;
        System.out.println("Input name(s):");
        String name = r.readLine();
        System.out.println("Input surname(s):");
        String surname = r.readLine();
        System.out.println("Input height(f):");
        float height = Float.parseFloat(r.readLine());
        System.out.println("Input weight(f):");
        float weight = Float.parseFloat(r.readLine());
        if (sex) {
            return new Men(name, surname, height, weight);
        } else {
            return new Woman(name, surname, height, weight);
        }
    }

    static Human testCompatibility(Human h1, Human h2) throws IOException {
        return h1.relationship(h2);
    }
}

