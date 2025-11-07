package cs112.ud3.UD2.Tools;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * A class designed to display an interactive menu for user input and selection.
 * All aspects of the menu are designed to be interchangable and reusable for
 * any purpose.
 * 
 * @author Andrew Ibarra
 * @version 1.0
 */
public class Menu {

    // INSTANCE VARIABLES //

    private String title;
    private String[] optionNames;

    // DEFAULT INSTANCE VARIABLES //

    private final Scanner terminalInput = new Scanner(System.in);
    private final String DEFAULT_TITLE = "No title";
    private final String[] DEFAULT_OPTION_NAMES = { "No Options" };

    // CONSTRUCTORS //

    public Menu() {
        setTitle(DEFAULT_TITLE);
        setOptionNames(DEFAULT_OPTION_NAMES);
    }

    public Menu(String title, String[] optionNames) {
        setTitle(title);
        setOptionNames(optionNames);
    }

    // ACCESSORS & MUTATORS //

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setOptionNames(String[] optionNames) {
        this.optionNames = optionNames;
    }

    public String[] getOptionNames() {
        return optionNames;
    }

    // METHODS //

    /*
     * private int promptInt(String message) {
     * 
     * boolean isActive = true;
     * int userChoice = 0;
     * 
     * do {
     * try {
     * System.out.printf(message);
     * userChoice = terminalInput.nextInt();
     * terminalInput.nextLine();
     * isActive = false;
     * } catch (InputMismatchException ime) {
     * terminalInput.nextLine();
     * System.out.printf("%nChoice must be an integer!");
     * }
     * } while (isActive);
     * return userChoice;
     * }
     */

    private int promptInt(String message, int lowerBound, int upperBound) {

        boolean isActive = true;
        int userChoice = 0;

        do {
            try {
                System.out.printf(message);
                userChoice = terminalInput.nextInt();
                terminalInput.nextLine();
                if (lowerBound > userChoice || userChoice > upperBound) {
                    throw new IllegalArgumentException();
                }
                isActive = false;
            } catch (InputMismatchException ime) {
                terminalInput.nextLine();
                System.out.printf("%nChoice must be an integer!");
            } catch (IllegalArgumentException iae) {
                System.out.printf("%nChoice must be between %d and %d!", lowerBound, upperBound);
            }
        } while (isActive);
        return userChoice;
    }

    public int runMenu() {

        boolean isActive = true;
        int upperBound = getOptionNames().length;
        int userChoice = 0;

        System.out.printf("%n%s%n", getTitle());

        System.out.printf("%n[0] > Esc");
        for (int i = 0; i < upperBound; i++) {
            System.out.printf("%n[%d] > %s", i + 1, getOptionNames()[i]);
        }

        do {
            userChoice = promptInt("%n%nYour choice: ", 0, upperBound);
            isActive = false;
        } while (isActive);

        if (userChoice == 0) {
            System.out.printf("%nGoodbye!%n");
            return 0;
        }
        return userChoice;
        // now to actually run some programs... userChoice

    }

}