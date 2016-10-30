package Home003;

import java.io.IOException;
import java.util.Random;

/**
 * Created by m.sokolovskiy on 28.10.2016.
 */
public class Human {
    private boolean men;
    private String name;
    private String surname;
    private float height;
    private float weight;

    Human(boolean men, String name, String surname, float height, float weight) {
        this.men = men;
        this.name = name;
        this.surname = surname;
        this.height = height;
        this.weight = weight;
    }

    boolean say(Human h) {
        Random rnd = new Random();
        System.out.print("Speaking: ");
        boolean flag;
        if (!this.men && !h.men) {
            flag = true;
        } else if (this.men != h.men) {
            flag = true;
        } else {
            flag = rnd.nextInt(10) < 5;
        }
        System.out.print(flag + "\n");
        return flag;
    }

    boolean tolerate(Human h) {
        Random rnd = new Random();
        System.out.print("Tolerate: ");
        boolean flag;
        if (!this.men && !h.men) {
            flag = rnd.nextInt(100) < 5;
        } else if (this.men != h.men) {
            flag = rnd.nextInt(10) < 7;
        } else {
            flag = rnd.nextInt(1000) < 56;
        }
        System.out.print(flag + "\n");
        return flag;
    }

    boolean together(Human h) {
        Random rnd = new Random();
        System.out.print("Together: ");
        boolean flag;
        float percent = Math.abs((this.height - h.height) / (this.height + h.height) / 2 * 100);

        if (percent > 10) {
            flag = rnd.nextInt(100) < 85;
        } else {
            flag = rnd.nextInt(100) < 95;
        }
        System.out.print(flag + "\n");
        return flag;
    }

    Human relationship(Human h) throws IOException {
        if (this.men != h.men) {
            if (this.say(h) && this.tolerate(h) && this.together(h)) {
                if (this.men) {
                    return ((Woman) h).birth(this);
                } else {
                    return ((Woman) this).birth(h);
                }
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Human{" +
                "men=" + men +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                '}';
    }
}
