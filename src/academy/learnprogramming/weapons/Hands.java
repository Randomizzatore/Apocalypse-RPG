package academy.learnprogramming.weapons;

public class Hands extends Weapon{

    public Hands() {
        super("Hands", 5, 0, 0, false);
    }

    @Override
    public int use() {
        return 1;
    }
}
