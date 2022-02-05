
public class PairOfDice {

    private Die die1;
    private Die die2;

    public PairOfDice() {
        die1 = new Die();
        die2 = new Die();
    }

    public void roll() {
        die1.roll();
        die2.roll();
    }

    public int getDie1() {
        return die1.getFace();
    }

    public int getDie2() {
        return die2.getFace();
    }

    public String toString() {
        return die1.getFace() + " and " + die2.getFace();
    }
}