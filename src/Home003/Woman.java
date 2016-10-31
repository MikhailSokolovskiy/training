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
        String cSurname = h.getSurname();
        if (rnd.nextInt(10) < 5) {
            float cHeight = h.getHeight() + 0.1f * (this.getHeight() - h.getHeight());
            float cWeight = h.getWeight() + 0.1f * (this.getWeight() - h.getWeight());
            return new Man(cName, cSurname, cHeight, cWeight);
        } else {
            float cHeight = this.getHeight() + 0.1f * (h.getHeight() - this.getHeight());
            float cWeight = this.getWeight() + 0.1f * (h.getWeight() - this.getWeight());
            return new Woman(cName, cSurname, cHeight, cWeight);
        }
    }
}
