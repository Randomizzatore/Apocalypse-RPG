package academy.learnprogramming.entities;

import academy.learnprogramming.weapons.Hammer;

public class Player {
    private EntityBaseData entityBaseData;

    public Player() {
        this("Default Name");
    }

    public Player(String playerName) {
        this(playerName, 0);
    }

    public Player(String playerName, long experience) {
        entityBaseData = new EntityBaseData(playerName, experience, 0, 100, 100, true);
        entityBaseData.getInventory().add(new Hammer());
    }

    public void printPlayerStats() {
        System.out.println("Player Name:   " + entityBaseData.getEntityName());
        System.out.println("Inventory:     " + entityBaseData.getInventoryToString());
        System.out.println("Experience:    " + entityBaseData.getExperience());
        System.out.println("Health Points: " + entityBaseData.getHealthPoints() + "/" + entityBaseData.getMaxHealthPoints());
    }

    public void attack(Opponent opponent) {
        int damage = entityBaseData.getSelectedWeapon().getDamage();
        opponent.receiveDamage(damage);
        entityBaseData.getSelectedWeapon().use();
        System.out.println("Damage done: " + damage + "\nZombie Health: " + opponent.getEntityBaseData().getHealthPoints() + "/" + opponent.getEntityBaseData().getMaxHealthPoints());
        if (!opponent.getEntityBaseData().isAlive()) entityBaseData.incrementEnemiesKilled();
    }

    public void receiveDamage(int damagePoints) {
        entityBaseData.setHealthPoints(entityBaseData.getHealthPoints() - damagePoints);
    }

    public void addExperience(long experience) {
        entityBaseData.addExperience(experience);
    }

    public EntityBaseData getEntityBaseData() {
        return entityBaseData;
    }


}
