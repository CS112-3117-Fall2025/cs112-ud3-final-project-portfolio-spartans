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
        scoreA = (int) (Math.random() * 10); // 0-9 runs in the game
        scoreB = (int) (Math.random() * 10);

        /** 
         * no ties 
         */
        while (scoreA == scoreB) {
            scoreB = (int) (Math.random() * 10);
        }
        return scoreA > scoreB ? teamA : teamB;
    }
    /**
     * a score summary of the game
     * @return
     */
    public String boxScore() {
    String result = teamA.getTeamCity() + " " + teamA.getTeamName() + " " + scoreA + " - "
                + teamB.getTeamCity() + " " + teamB.getTeamName() + " " + scoreB + "\n";
    result += "Winner: " + (scoreA > scoreB 
                            ? teamA.getTeamCity() + " " + teamA.getTeamName() 
                            : teamB.getTeamCity() + " " + teamB.getTeamName());
    return result;
    }
}
