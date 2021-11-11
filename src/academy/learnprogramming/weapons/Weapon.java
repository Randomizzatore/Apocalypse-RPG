package academy.learnprogramming.weapons;

public class Weapon {
    private final String name;
    private final int damage;
    private final int maxHealthPoints;
    private int healthPoints;
    private boolean broken;

    public Weapon(String name, int damage, int maxHealthPoints, int healthPoints, boolean broken) {
        this.name = name;
        this.damage = damage;
        this.maxHealthPoints = maxHealthPoints;
        this.healthPoints = healthPoints;
        this.broken = broken;
    }

    //TODO Test this
    // This is the method that uses the weapon to wear it down
    // 1 = Weapon successfully used
    // 0 = Weapon broken by the use
    // -1 = Weapon was already broken
    public int use() {
        if (this.healthPoints > 0) {
            this.healthPoints--;
            if (this.healthPoints == 0) {
                this.broken = true;
                return 0;
            }
            return 1;
        } else return -1;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }
}
