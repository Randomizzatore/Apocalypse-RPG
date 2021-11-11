package academy.learnprogramming;

import academy.learnprogramming.entities.Opponent;
import academy.learnprogramming.entities.Player;

import java.util.Locale;

public class GameController {
    private Player player;

    public GameController() {
        System.out.println("    ___                           __                         ____  ____  ______\n" +
                "   /   |  ____  ____  _________ _/ __  ______  ________     / __ \\/ __ \\/ ____/\n" +
                "  / /| | / __ \\/ __ \\/ ___/ __ `/ / / / / __ \\/ ___/ _ \\   / /_/ / /_/ / / __  \n" +
                " / ___ |/ /_/ / /_/ / /__/ /_/ / / /_/ / /_/ (__  /  __/  / _, _/ ____/ /_/ /  \n" +
                "/_/  |_/ .___/\\____/\\___/\\__,_/_/\\__, / .___/____/\\___/  /_/ |_/_/    \\____/   \n" +
                "      /_/                       /____/_/                                     ");
        initializePlayer();
        player.printPlayerStats();
    }

    public boolean Start() {
        // This is the main loop of the game
        int quitMode = -1;
        int encounterNumber = 1;
        Opponent opponent;
        while (player.getEntityBaseData().isAlive() && quitMode == -1) {
            opponent = new Opponent();
            System.out.println("============== ENCOUNTER #"+encounterNumber+" ==============");
            System.out.println("The player has met a zombie!");
            opponent.printZombieStats();
            while (quitMode == -1) {
                int opponentIsDead = 0;
                switch (playerTurn(opponent)) {
                    case 0: break;
                    case 1:
                        opponentIsDead = 1;
                        break;
                    case 2: quitMode = 0;
                }
                if (quitMode == 0) break;
                if (opponentIsDead == 1) {
                    lootGatherPhase();
                    break;
                }
                //TODO Need a way to get weapons from the enemy!!!
                switch (enemyTurn(opponent)) {
                    case 0: break;
                    case 1: quitMode = 1;
                }
            }
            encounterNumber++;
            System.out.println("==========================================");
        }
        quit(quitMode);
        return true;
    }

    private void lootGatherPhase() {

    }

    // Gives the player a name selected by the user
    private boolean initializePlayer() {
        String newName;
        System.out.print("Please enter the player name: ");
        newName = Main.scanner.nextLine();
        this.player = new Player(newName);
        return true;
    }

    // This method asks the player for a decision
    // The player types a number and the available selection number is returned
    // The loop does not allow for not admissible number to be selected.

    private int getPlayerDecision() {
        int decision = 0;
        System.out.print("What do you want to do!?\n(1) Attack\n(2) Change selected weapon\n(3) Manage inventory\n(0) Quit\n");

        do {
            if (Main.scanner.hasNextInt()) decision = Main.scanner.nextInt();
        }
        while (decision < 0 || decision > 3);

        return decision;
    }

    // This is the PLAYER turn, the player decision is made here and the outcome is returned
    // Return value meaning:
    // 0 = Enemy is still alive
    // 1 = Enemy was killed by the player
    // 2 = Player decided to quit
    private int playerTurn(Opponent opponent) {
        System.out.println("[PLAYER TURN]");
        while (true) {
            switch (getPlayerDecision()) {
                case 0:
                    return 2;
                case 1:
                    System.out.println("You attack the " + opponent.getEntityBaseData().getEntityName() + "!");
                    player.attack(opponent);
                    if (!opponent.getEntityBaseData().isAlive()) {
                        System.out.println("The " + opponent.getEntityBaseData().getEntityName() + " is dead!");
                        long exp = opponent.getEntityBaseData().getExperience();
                        player.addExperience(exp);
                        System.out.println("Experience gained: " + exp);
                        return 1;
                    }
                    return 0;
                case 2:
                    player.getEntityBaseData().changeSelectedWeapon();
                    break;
                case 3:
                    player.getEntityBaseData().printInventory();
                    break;
                default:
                    return 0;
            }
        }

    }

    private int quit(int type) {
        if (type == 1) System.out.println("OH NO YOU WERE KILLED BY THE OPPONENT!");
        else if (type == 0) System.out.println("YOU DECIDED TO QUIT THIS IMPOSSIBLE AND DIFFICULT GAME");
        System.out.println("Player " + player.getEntityBaseData().getEntityName() + " statistics:\n" +
                "EXPERIENCE:     " + player.getEntityBaseData().getExperience() +
                "\nENEMIES KILLED: " + player.getEntityBaseData().getEnemiesKilled() +
                "\nThe end! Thanks for playing Apocalypse RPG! - Randomizzatore");
        return type;
    }

    // This is the ENEMY turn, the player decision is made here and the outcome is returned
    // Return value meaning:
    // 0 = Player is still alive
    // 1 = Player was killed by the enemy
    private int enemyTurn(Opponent opponent) {
        System.out.println("[ZOMBIE TURN]");
        System.out.println("The zombie attacks you!");
        opponent.attack(player);
        return (player.getEntityBaseData().isAlive()) ? 0 : 1;
    }
}
