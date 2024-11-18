package tracker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Learning Progress Tracker");

        while (true) {
            String command = input.nextLine();
            if (command.equals("exit")) {
                System.out.println("Bye!");
                break;
            } else if (command.isBlank()) {
                System.out.println("No input.");
            } else {
                System.out.println("Error: unknown command!");
            }
        }
    }
}
