package academy.learnprogramming.entities;

import academy.learnprogramming.Main;
import academy.learnprogramming.weapons.Hands;
import academy.learnprogramming.weapons.Weapon;

import java.util.ArrayList;

public class EntityBaseData {
    private final String entityName;
    private long experience;
    private int enemiesKilled;
    private int healthPoints;
    private final int maxHealthPoints;
    private boolean isAlive;
    private ArrayList<Weapon> inventory;
    private Weapon selectedWeapon;

    public EntityBaseData() {
        this("Default Name", 0,0,100,100,true);
    }

    public EntityBaseData(String entityName, long experience, int enemiesKilled, int healthPoints, int maxHealthPoints, boolean isAlive) {
        this.entityName = entityName;
        this.experience = experience;
        this.enemiesKilled = enemiesKilled;
        this.healthPoints = healthPoints;
        this.maxHealthPoints = maxHealthPoints;
        this.isAlive = isAlive;
        this.inventory = new ArrayList<>();
        inventoryAddWeapon(new Hands());
        this.selectedWeapon = inventory.get(0);
    }

    // This method adds a weapon to the main inventory
    // 1 = Weapon successfully added to the inventory
    // 0 = Weapon was null
    public int inventoryAddWeapon(Weapon w) {
        if (w != null) {
            this.inventory.add(w);
            return 1;
        }
        return 0;
    }

    public String getEntityName() {
        return entityName;
    }

    public long getExperience() {
        return experience;
    }

    public int getEnemiesKilled() {
        return enemiesKilled;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public int getMaxHealthPoints() {
        return maxHealthPoints;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public Weapon getSelectedWeapon() {
        return selectedWeapon;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = Math.max(0, healthPoints);
        if (this.healthPoints == 0) this.isAlive = false;
    }

    public ArrayList<Weapon> getInventory() {
        return inventory;
    }

    public void incrementEnemiesKilled() {
        this.enemiesKilled++;
    }

    public void addExperience(long experience) {
        this.experience += experience;
    }

    public void changeSelectedWeapon() {
        int decision = 0;
        System.out.println("Select the weapon that you want to use:\n" + getNumberedInventoryToString());
        while (true) {
            decision = Main.scanner.nextInt();
            if (!inventory.isEmpty() && decision-1 >= 0 && decision-1 <= inventory.size()) {
                selectedWeapon = inventory.get(decision-1);
                break;
            }
        }
    }

    public String getInventoryToString() {
        StringBuilder s = new StringBuilder("");
        for (int i = 0; i < inventory.size(); i++) {
            s.append(inventory.get(i).getName()).append((i == inventory.size() - 1) ? "" : ",");
        }
        return s.toString();
    }

    public String getNumberedInventoryToString() {
        StringBuilder s = new StringBuilder("");
        String string = "";
        for (int i = 0; i < inventory.size(); i++) {
            Weapon w = inventory.get(i);
            string = "(" + (i+1) + ") " + w.getName() + " DMG:" + w.getDamage() + "\n";
            s.append(string);
        }
        return s.toString();
    }

    public void printInventory() {
        System.out.print(getNumberedInventoryToString());
    }

}
