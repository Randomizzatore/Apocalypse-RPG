package academy.learnprogramming;

import java.util.Locale;

public class GameController {
    private Player player;

    public GameController() {
        initializePlayer();
        player.printPlayerStats();
    }

    public boolean Start() {
        // This is the main loop of the game
        Zombie zombie;
        while (player.isAlive()) {
            zombie = new Zombie();
            System.out.println("The player has met a zombie!");
            zombie.printZombieStats();

            while (true) {
                // Player turn
                System.out.println("[[[PLAYER TURN]]]");
                if (getPlayerDecision() == 1) {
                    System.out.print("You attack the zombie! ");
                    player.attack(zombie);
                    if (!zombie.isAlive()) {
                        System.out.println("The zombie is dead!");
                        player.addExperience(zombie.getExperience());
                        if (zombie.hasBaseballBat() && !player.hasBaseballBat()) {
                            System.out.println("The zombie was carrying a baseball bat! The player will do DOUBLE DAMAGE from now on!");
                            player.setHasBaseballBat(true);
                        }
                        break;
                    }
                }
                // Zombie turn
                System.out.println("[[[ZOMBIE TURN]]]");
                System.out.print("The zombie attacks you! ");
                zombie.attack(player);
                if (!player.isAlive()) break;
            }
        }

        System.out.println("Oh no, you died!");
        System.out.println("Player " + player.getPlayerName() + " collected " + player.getExperience() + " experience points!");
        System.out.println("The end! Thanks for playing! - Randomizzatore");
        return true;
    }

    // Gives the player a name selected by the user
    private boolean initializePlayer() {
        String newName;
        System.out.println("Please enter the player name: ");
        newName = Main.scanner.nextLine();
        this.player = new Player(newName);

        return true;
    }

    public int getPlayerDecision() {
        String decision = "";
        boolean hasScanned = false;

        System.out.println("What do you want to do? (attack)");

        do {
            if (Main.scanner.hasNextLine()) {
                decision = Main.scanner.nextLine();
            }
        }
        while (!decision.toLowerCase(Locale.ROOT).equals("attack"));

        return (decision.equals("attack")) ? 1 : 0;
    }

}
