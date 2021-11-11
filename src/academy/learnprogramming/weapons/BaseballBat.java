package academy.learnprogramming.weapons;

public class BaseballBat extends Weapon{

    public BaseballBat() {
        this(30);
    }

    public BaseballBat(int healthPoints) {
        super("Baseball Bat", 15, 30, healthPoints, false);
    }
}
