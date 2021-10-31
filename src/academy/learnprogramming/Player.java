package academy.learnprogramming;

public class Player {
    private String playerName;
    private long experience;
    private int healthPoints;
    private boolean isAlive;
    private boolean hasBaseballBat;

    public Player() {
        this.playerName = "default name";
        this.experience = 0;
        this.healthPoints = 100;
        this.isAlive = true;
    }

    public Player(String playerName) {
        this(playerName, 0);
    }


    public Player(String playerName, long experience) {
        System.out.println("A new player is born! " + this.toString());
        this.playerName = playerName;
        this.experience = experience;
        this.healthPoints = 100;
        this.isAlive = true;
        this.hasBaseballBat = false;
    }

    public boolean hasBaseballBat() {
        return this.hasBaseballBat;
    }

    public void printPlayerStats() {
        System.out.println("Player Name:   " + this.playerName);
        System.out.println("Experience:    " + this.experience);
        System.out.println("Health Points: " + this.healthPoints);
        System.out.println("Alive:         " + this.isAlive);
    }

    public void attack(Zombie zombie) {
        int damage = 10;
        if (this.hasBaseballBat()) damage *= 2;
        zombie.receiveDamage(damage);
        System.out.println(" Damage done: " + damage + " Zombie Health: " + zombie.getHealthPoints());
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

    public String getPlayerName() {
        return this.playerName;
    }

    public long getExperience() {
        return this.experience;
    }

    public int getHealthPoints() {
        return this.healthPoints;
    }

    public boolean isAlive() {
        return this.isAlive;
    }

    public void isAlive(boolean status) {
        this.isAlive = status;
    }

    public void setExperience(long experience) {
        this.experience = experience;
    }

    public void addExperience(long experience) {
        this.setExperience(this.getExperience() + experience);
    }

    public void setHasBaseballBat(boolean status) {
        this.hasBaseballBat = status;
    }
}
