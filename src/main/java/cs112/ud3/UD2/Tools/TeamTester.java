package cs112.ud3.UD2.Tools;

import cs112.ud3.UD2.Baseball.*;

/**
 * A tester class designed to ensure methods, classes, objects, etc. in this
 * program are functioning as intended. If this class fails to execute, it is
 * indicitive of some sort of bug in need of being addressed.
 * 
 * @author Mya B.
 * @version 1.0
 */
public class TeamTester {
    public static void main(String[] args) {

        // Default Constructor
        Team defaultTeam = new Team();
        System.out.println("Default Team:");
        System.out.println(defaultTeam.toString());

        // main Constructor
        Player[] roster = {
                new Player("John", "Doe", 10, 1, 150),
                new Player("Jane", "Smith", 12, 2, 140)
        };
        Team paramTeam = new Team("Test City", "Testers", "TC", roster, 10, 5, 6, 2, 50, 30);
        System.out.println("\nParameterized Team:");
        System.out.println(paramTeam.toString());

        // Copy Constructor
        Team copyTeam = new Team(paramTeam);
        System.out.println("\nCopied Team:");
        System.out.println(copyTeam.toString());

        // Setters & Getters
        copyTeam.setTeamCity("New City");
        copyTeam.setWins(12);
        copyTeam.setLosses(3);
        System.out.println("\nAfter modifying copyTeam:");
        System.out.println("City: " + copyTeam.getTeamCity());
        System.out.println("Wins: " + copyTeam.getWins());
        System.out.println("Losses: " + copyTeam.getLosses());

        // equals method
        System.out.println("\nTesting equals method:");
        System.out.println("paramTeam equals copyTeam? " + paramTeam.equals(copyTeam));
        System.out.println("paramTeam equals paramTeam? " + paramTeam.equals(paramTeam));

        // Roster manipulation
        Player newPlayer = new Player("Alex", "Johnson", 15, 3, 160);
        boolean added = paramTeam.addPlayerToRoster(newPlayer);
        System.out.println("\nAdding player Alex Johnson: " + added);
        boolean removed = paramTeam.removePlayerFromRoster(roster[0]);
        System.out.println("Removing player John Doe: " + removed);

        // Swap & push roster positions
        paramTeam.swapRosterPosition(0, 1);
        paramTeam.pushRosterPosition(1, 0);
        System.out.println("\nRoster after swap and push:");
        for (String name : paramTeam.getRosterNames()) {
            System.out.println(name);
        }

        // Run differential & winning percentages
        System.out.println("\nRun Differential: " + paramTeam.getRunDifferential());
        System.out.println("Winning Percentage: " + paramTeam.getWinningPercentage());
    }
}
