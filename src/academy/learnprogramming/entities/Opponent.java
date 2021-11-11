package academy.learnprogramming.entities;

import java.util.Random;

public class Opponent {
    private EntityBaseData entityBaseData;

    public Opponent() {
        this("Zombie", 1, 100);
    }

    public Opponent(String zombieName, long experience, int healthPoints) {
        entityBaseData = new EntityBaseData(zombieName, experience, 0, healthPoints, healthPoints, true);
    }

    public void printZombieStats() {
        System.out.println("Zombie Name:   " + entityBaseData.getEntityName());
        System.out.println("Health Points: " + entityBaseData.getHealthPoints() + "/" + entityBaseData.getMaxHealthPoints());
    }

    public void attack(Player player) {
        Random random = new Random();
        int damage = random.nextInt(6);
        player.receiveDamage(damage);
        System.out.println("Damage received: " + damage + "\nPlayer Health: " + player.getEntityBaseData().getHealthPoints() + "/" + player.getEntityBaseData().getMaxHealthPoints());
    }

    public void receiveDamage(int damagePoints) {
            entityBaseData.setHealthPoints(entityBaseData.getHealthPoints() - damagePoints);
    }

    public EntityBaseData getEntityBaseData() {
        return entityBaseData;
    }
}
