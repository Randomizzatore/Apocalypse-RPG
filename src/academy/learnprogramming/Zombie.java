package academy.learnprogramming;

import java.util.Random;

public class Zombie {
    private String zombieName;
    private long experience;
    private int healthPoints;
    private boolean isAlive;
    private boolean hasBaseballBat;

    public Zombie() {
        this("Zombie", 1, 100);
        System.out.println("A new zombie is born! " + this.toString());
    }

    public Zombie(String zombieName, long experience, int healthPoints) {
        this.zombieName = zombieName;
        this.experience = experience;
        this.healthPoints = healthPoints;
        this.isAlive = true;
        this.hasBaseballBat = new Random().nextDouble() <= 0.1;
    }

    public void printZombieStats() {
        System.out.println("Zombie Name:   " + this.zombieName);
        System.out.println("Experience:    " + this.experience);
        System.out.println("Health Points: " + this.healthPoints);
        System.out.println("Alive:         " + this.isAlive);
    }

    public void attack(Player player) {
        Random random = new Random();
        int damage = random.nextInt(5);
        player.receiveDamage(damage);
        System.out.println(" Damage received: " + damage + " Player Health: " + player.getHealthPoints());
    }

    public void receiveDamage(int damagePoints) {
        if (damagePoints > 0) {
            this.healthPoints -= damagePoints;
            if (this.healthPoints <= 0) {
                this.healthPoints = 0;
                this.isAlive(false);
            }
        }
    }

    public String getZombieName() {
        return zombieName;
    }

    public long getExperience() {
        return experience;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void isAlive(boolean status) {
        this.isAlive = status;
    }

    public boolean hasBaseballBat() {
        return this.hasBaseballBat;
    }
}
