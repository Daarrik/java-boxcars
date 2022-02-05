import java.util.Random;

public class Die {

    public static Random rand = new Random();
    public static final int NUMBER_OF_SIDES = 6;
    private int face;

    public Die() {
        face = 0;
    }

    public int roll() {
        face = rand.nextInt(NUMBER_OF_SIDES) + 1;
        return face;
    }

    public int getFace() {
        return face;
    }

    public String toString() {
        return "" + face;
    }
}