package academy.learnprogramming.weapons;

public class Hammer extends Weapon {

    public Hammer() {
        this(10);
    }
    public Hammer(int healthPoints) {
        super("Hammer", 30, 10, healthPoints, false);
    }
}
