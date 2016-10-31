package Home003;

import java.io.IOException;
import java.util.Random;

/**
 * Created by m.sokolovskiy on 28.10.2016.
 */
public class Human {
    private boolean man;
    private String name;
    protected String surname;
    protected float height;
    protected float weight;

    Human(boolean man, String name, String surname, float height, float weight) {
        this.man = man;
        this.name = name;
        this.surname = surname;
        this.height = height;
        this.weight = weight;
    }

    boolean say(Human h) {
        Random rnd = new Random();
        System.out.print("Speaking: ");
        boolean flag;
        if (!this.man && !h.man) {
            flag = true;
        } else if (this.man != h.man) {
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
        if (!this.man && !h.man) {
            flag = rnd.nextInt(100) < 5;
        } else if (this.man != h.man) {
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
        if (this.man != h.man) {
            if (this.say(h) && this.tolerate(h) && this.together(h)) {
                if (this.man) {
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
                "man=" + man +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                '}';
    }
}
