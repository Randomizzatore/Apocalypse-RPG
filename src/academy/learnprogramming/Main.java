package academy.learnprogramming;

import java.util.Scanner;

//      ___                           __                         ____  ____  ______
//     /   |  ____  ____  _________ _/ __  ______  ________     / __ \/ __ \/ ____/
//    / /| | / __ \/ __ \/ ___/ __ `/ / / / / __ \/ ___/ _ \   / /_/ / /_/ / / __
//   / ___ |/ /_/ / /_/ / /__/ /_/ / / /_/ / /_/ (__  /  __/  / _, _/ ____/ /_/ /
//  /_/  |_/ .___/\____/\___/\__,_/_/\__, / .___/____/\___/  /_/ |_/_/    \____/
//        /_/                       /____/_/

public class Main {

    public static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        GameController gc = new GameController();
        gc.Start();
        scanner.close();
    }
}
