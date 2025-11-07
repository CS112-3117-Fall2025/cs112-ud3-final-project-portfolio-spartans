package cs112.ud3.UD2;

import cs112.ud3.UD2.Baseball.*;
import cs112.ud3.UD2.Tools.*;

/**
 * The steering wheel of this entire program. Will contain minimal code,
 * primarily used to execute other classes and maintain specific order of
 * operation.
 * 
 * @author Andrew Ibarra, Mya B.
 * @version 1.0
 */
public class Main {
    
    public static void main(String[] args) {

        MajorLeague testA = RealStatistics.allTeams;
        Team testB = RealStatistics.blueJays;

        Menu teamChoices = new Menu("Choose your team: ", testA.getLeagueRosterNames());
        Menu playerChoices = new Menu("Choose your player: ", testB.getRosterNames());

        int teamChoice = teamChoices.runMenu();
        int playerChoice = playerChoices.runMenu();

        System.out.printf("You chose team \"%s\" with player \"%s\"!%n", testA.getLeagueRosterNames()[teamChoice - 1],
                testB.getRosterNames()[playerChoice - 1]);

        // Mya 
        Team userTeam = RealStatistics.allTeams.getLeagueRoster()[0];  // first team 
        Team opponentTeam = RealStatistics.allTeams.getLeagueRoster()[1]; // second team 
        
        Game game = new Game(userTeam, opponentTeam);
        Team winner = game.playGame();
        System.out.println(game.boxScore());
        System.out.println("Winner is: " + winner.getTeamCity() + " " + winner.getTeamName());
    }
}