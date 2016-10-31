package Home003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

/**
 * Created by m.sokolovskiy on 30.10.2016.
 */
public class Woman extends Human {
    Woman(String name, String surname, float height, float weight) {
        super(false, name, surname, height, weight);
    }

    protected Human birth(Human h) throws IOException {
        Random rnd = new Random();
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input name of child:");
        String cName = r.readLine();
        String cSurname = h.surname;
        if (rnd.nextInt(10) < 5) {
            float cHeight = h.height + 0.1f * (this.height - h.height);
            float cWeight = h.weight + 0.1f * (this.weight - h.weight);
            return new Man(cName, cSurname, cHeight, cWeight);
        } else {
            float cHeight = this.height + 0.1f * (h.height - this.height);
            float cWeight = this.weight + 0.1f * (h.weight - this.weight);
            return new Woman(cName, cSurname, cHeight, cWeight);
        }
    }
}
