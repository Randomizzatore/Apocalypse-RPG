package academy.learnprogramming.weapons;

public class Knife extends Weapon{

    public Knife() {
        this(20);
    }

    public Knife(int healthPoints) {
        super("Knife", 20, 20, healthPoints, false);
    }
}
