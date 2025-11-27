package cs112.ud3.UD2.Baseball;

/**
 * A game class that will display dialogue of an interactive game. Will decide a
 * winner or loser, and will change statistics on teams and players after game
 * has been completed.
 * 
 * @author Mya B.
 * @version 1.0
 * 
 *          - teamA : Team
 *          - teamB : Team
 *          - scoreA : int
 *          - scoreB : int
 * 
 *          + Game()
 *          + Game(leagueName : String, leagueRoster : Team[])
 *          + Game(majorLeague : MajorLeague)
 * 
 *          + setTeamA(teamA : Team) : void
 *          + setTeamB(teamB : Team) : void
 *          + setScoreA(scoreA : int) : void
 *          + setScoreB(scoreB : int) : void
 * 
 *          + playGame() : Team
 *          + boxScore() : String
 * 
 */
public class Game {

    // INSTANCE VARIABLES //
    private Team teamA;
    private Team teamB;
    private int scoreA;
    private int scoreB;

    // DEFAULT INSTANCE VARIABLES //
    private final Team DEFAULT_TEAM = null;
    private final int DEFAULT_SCORE = 0;

    // CONSTRUCTORS //
     /** Default constructor */
    public Game() {
        this.teamA = DEFAULT_TEAM;
        this.teamB = DEFAULT_TEAM;
        this.scoreA = DEFAULT_SCORE;
        this.scoreB = DEFAULT_SCORE;
    }

    /** Main constructor */
    public Game(Team a, Team b) {
        this.teamA = a;
        this.teamB = b;
        this.scoreA = 0;
        this.scoreB = 0;
    }

    /** Copy constructor */
    public Game(Game other) {
        this.teamA = other.getTeamA();
        this.teamB = other.getTeamB();
        this.scoreA = other.getScoreA();
        this.scoreB = other.getScoreB();
    }

    // ACCESSORS (getters) //
    public Team getTeamA() {
        return teamA;
    }

    public Team getTeamB() {
        return teamB;
    }

    public int getScoreA() {
        return scoreA;
    }

    public int getScoreB() {
        return scoreB;
    }

    // MUTATORS (setters) //
    public void setTeamA(Team teamA) {
        this.teamA = teamA;
    }

    public void setTeamB(Team teamB) {
        this.teamB = teamB;
    }

    public void setScoreA(int scoreA) {
        this.scoreA = scoreA;
    }
    public void setScoreB(int scoreB) {
        this.scoreB = scoreB;
    }

    // METHODS //

    /**
     * Simulates the game with randomly generated runs for each team.
     * Also, prevents ties by re-rolling until scores are different.
     */
    public Team playGame() {
        scoreA = (int) (java.lang.Math.random() * 10); // 0-9 runs in the game
        scoreB = (int) (java.lang.Math.random() * 10);

        /** 
         * no ties 
         */
        while (scoreA == scoreB) {
            scoreB = (int) (Math.random() * 10);
        }
        // Update all team and player stats after the game
        updateStats();
        return scoreA > scoreB ? teamA : teamB;
    }
    private void updateStats() {
        // 1. Update Team Wins/Losses
        if (scoreA > scoreB) {
            teamA.setWins(teamA.getWins() + 1);
            teamB.setLosses(teamB.getLosses() + 1);
        } else {
            teamB.setWins(teamB.getWins() + 1);
            teamA.setLosses(teamA.getLosses() + 1);
        }

        // 2. Update Team Runs Scored/Allowed

        teamA.setRunsScored(teamA.getRunsScored() + scoreA);
        teamA.setRunsAllowed(teamA.getRunsAllowed() + scoreB);

        teamB.setRunsScored(teamB.getRunsScored() + scoreB);
        teamB.setRunsAllowed(teamB.getRunsAllowed() + scoreA);

        // 3. Update Player Games Played

        // Update Team A Players
        for (Player p : teamA.getRoster()) {
            p.setGamesPlayed(p.getGamesPlayed() + 1);
        }

        // Update Team B Players
        for (Player p : teamB.getRoster()) {
            p.setGamesPlayed(p.getGamesPlayed() + 1);
        }
    }
    /**
     * a score summary of the game
     * @return A formatted String containing the final score and winner
     */
    public String boxScore() {
        String teamAName = teamA.getTeamCity() + " " + teamA.getTeamName();
        String teamBName = teamB.getTeamCity() + " " + teamB.getTeamName();

        String result = String.format("%s %d - %s %d%n", teamAName, scoreA, teamBName, scoreB);

        result += "Winner: " + (scoreA > scoreB
                ? teamAName
                : teamBName);
        return result;
    }
}
