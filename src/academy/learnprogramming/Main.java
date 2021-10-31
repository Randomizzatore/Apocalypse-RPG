package academy.learnprogramming;

import java.util.Scanner;

public class Main {

    public static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        GameController gc = new GameController();
        gc.Start();
        scanner.close();
    }
}
