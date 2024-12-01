package tracker;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


enum NameValidationRegex {
    FIRST_NAME("(?:[A-Z][a-z]+[\\\\-]*[A-Z][a-z]+)|(?:[A-Z][a-z]+)|(?:[A-Z][\\']*[A-Z][a-z]+)"),
    LAST_NAME(""),
    EMAIL("");
    private final String regex;
    NameValidationRegex(String regex) {
        this.regex = regex;
    }

    public String getRegex() {
        return regex;
    }
}
public class Main {



    public static void main(String[] args) {
        showMenu();
    }

    public static void showMenu() {
        Scanner input = new Scanner(System.in);
        System.out.println("Learning Progress Tracker");
        int studentCount = 0;

        while (true) {
            String command = input.nextLine().toLowerCase();
            if (command.equals("exit")) {
                System.out.println("Bye!");
                break;
            } else if (command.equals("add students")) {
                System.out.println("Enter student credentials or 'back' to return");

                while (true) {
                    String credential = input.nextLine();
                    Credential user = getCredential(credential);
                    validate(user);
                    if (credential.equalsIgnoreCase("back")) {
                        if (studentCount == 0) {
                            System.out.println("Enter 'exit' to exit the program.");
                            break;
                        } else {
                            System.out.printf("Total %d students have been added.", studentCount);
                        }
                    }


                    studentCount++;
                }
            } else if (command.isBlank()) {
                System.out.println("No input.");
            } else {
                System.out.println("Error: unknown command!");
            }
        }

    }

    private static Credential validate(Credential user) {
        Pattern pattern = Pattern.compile(NameValidationRegex.FIRST_NAME.getRegex());
        Matcher matcher = pattern.matcher(user.getFirstName());
        user.setValidFirstName(matcher.hasMatch());
        pattern = Pattern.compile(NameValidationRegex.LAST_NAME.getRegex());
        matcher = pattern.matcher(user.getLastName());
        user.setValidLastName(matcher.hasMatch());;
        pattern = Pattern.compile(NameValidationRegex.EMAIL.getRegex());
        matcher = pattern.matcher(user.getEmail());
        user.setValidEmail(matcher.hasMatch());

        return user;
    }

    private static void validateField(Credential user, NameValidationRegex regex) {
        Pattern pattern = Pattern.compile(regex.getRegex());
        Matcher matcher = pattern.matcher(user.getFirstName());
        user.setValidFirstName(matcher.hasMatch());
    }
    static Credential getCredential(String credential) {
        List<String> names = List.of(credential.split(" "));
        String firstName = names.getFirst();
        StringBuilder lastName = new StringBuilder();
        String email = names.getLast();
        for (int i = 1; i < names.size() - 1; i++) {
            lastName.append(names.get(i)).append(" ");
        }
        return new Credential(firstName, lastName.toString(), email);
    }
}
