package cs112.ud3.UD2.Baseball;

import cs112.ud3.UD2.Tools.Math;

/**
 * A team class designed to store players with special ordering and categorizing
 * rules (critical for an active game). Also contains some historical statistics
 * associated with this team.
 * 
 * @author Andrew Ibarra
 * @version 1.0
 * 
 * 
 *          - teamCity : String
 *          - teamName : String
 *          - teamAbbv : String
 *          - roster : Player[]
 *          - hittingRoster : Player[]
 *          - pitchingRoster : Player[]
 *          - wins : int
 *          - losses : int
 *          - winsAtHome : int
 *          - lossesAtHome : int
 *          - runsScored : int
 *          - runsAllowed : int
 * 
 *          + Team()
 *          + Team(teamCity : String, teamName : String, teamAbbv : String,
 *          roster : Player[], wins : int, losses : int, winsAtHome : int,
 *          lossesAtHome : int, runsScored : int, runsAllowed : int)
 *          + Team(team : Team)
 * 
 *          + setTeamCity(teamCity : String) : void
 *          + getTeamCity() : String
 *          + setTeamName(teamName : String) : void
 *          + getTeamName() : String
 *          + setTeamAbbv(teamAbbv : String) : void
 *          + getTeamAbbv() : String
 *          + setRoster(roster : Player[]) : void
 *          + getRoster() : Player[]
 *          + setHittingRoster(hittingRoster : Player[]) : void
 *          + getHittingRoster() : Player[]
 *          + setPitchingRoster(pitchingRoster : Player[]) : void
 *          + getPitchingRoster() : Player[]
 *          + setWins(wins : int) : void
 *          + getWins() : int
 *          + setLosses(losses : int) : void
 *          + getLosses() : int
 *          + setWinsAtHome(winsAtHome : int) : void
 *          + getWinsAtHome() : int
 *          + setLossesAtHome(lossesAtHome : int) : void
 *          + getLossesAtHome() : int
 *          + setRunsScored(runsScored : int) : void
 *          + getRunsScored() : int
 *          + setRunsAllowed(runsAllowed : int) : void
 *          + getRunsAllowed() : int
 * 
 *          + equals(otherTeam : Object) : boolean
 *          + toString() : String
 *          + getRunDifferential() : int
 *          + getWinningPercentage() : double
 *          + addPlayerToRoster(player : Player) : boolean
 *          + removePlayerFromRoster(player : Player) : boolean
 *          + swapRosterPosition(posA : int, posB : int) : boolean
 *          + pushRosterPosition(from : int, to : int) : boolean
 *          + getRosterNames() : String[]
 * 
 */
public class Team extends MajorLeague {

    // INSTANCE VARIABLES //

    private String teamCity, teamName, teamAbbv;
    private Player[] roster, hittingRoster, pitchingRoster;

    private int wins, losses;
    private int winsAtHome, lossesAtHome;
    private int runsScored, runsAllowed;

    // DEFAULT INSTANCE VARIABLES //

    private final String DEFAULT_TEAM_CITY = "None", DEFAULT_TEAM_NAME = "None", DEFAULT_TEAM_ABBV = "NA";
    private final Player[] DEFAULT_ROSTER = null, DEFAULT_HITTING_ROSTER = null, DEFAULT_PITCHING_ROSTER = null;

    private final int DEFAULT_WINS = 0, DEFAULT_LOSSES = 0;
    private final int DEFAULT_WINS_AT_HOME = 0, DEFAULT_LOSSES_AT_HOME = 0;
    private final int DEFAULT_RUNS_SCORED = 0, DEFAULT_RUNS_ALLOWED = 0;

    // CONSTRUCTORS //

    public Team() {
        setTeamCity(DEFAULT_TEAM_CITY);
        setTeamName(DEFAULT_TEAM_NAME);
        setTeamAbbv(DEFAULT_TEAM_ABBV);
        setRoster(DEFAULT_ROSTER);
        setHittingRoster(DEFAULT_HITTING_ROSTER); 
        setPitchingRoster(DEFAULT_PITCHING_ROSTER); 
        setWins(DEFAULT_WINS);
        setLosses(DEFAULT_LOSSES);
        setWinsAtHome(DEFAULT_WINS_AT_HOME);
        setLossesAtHome(DEFAULT_LOSSES_AT_HOME);
        setRunsScored(DEFAULT_RUNS_SCORED);
        setRunsAllowed(DEFAULT_RUNS_ALLOWED);
    }

    public Team(String teamCity, String teamName, String teamAbbv, Player[] roster, int wins, int losses,
            int winsAtHome, int lossesAtHome, int runsScored, int runsAllowed) {
        setTeamCity(teamCity);
        setTeamName(teamName);
        setTeamAbbv(teamAbbv);
        setRoster(roster);
        setWins(wins);
        setLosses(losses);
        setWinsAtHome(winsAtHome);
        setLossesAtHome(lossesAtHome);
        setRunsScored(runsScored);
        setRunsAllowed(runsAllowed);
    }

    public Team(Team team) {
        setTeamCity(team.getTeamCity());
        setTeamName(team.getTeamName());
        setTeamAbbv(team.getTeamAbbv());
        setRoster(team.getRoster());
        setWins(team.getWins());
        setLosses(team.getLosses());
        setWinsAtHome(team.getWinsAtHome());
        setLossesAtHome(team.getLossesAtHome());
        setRunsScored(team.getRunsScored());
        setRunsAllowed(team.getRunsAllowed());
    }

    // ACCESSORS & MUTATORS //

    public void setTeamCity(String teamCity) {
        this.teamCity = teamCity;
    }

    public String getTeamCity() {
        return teamCity;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamAbbv(String teamAbbv) {
        this.teamAbbv = teamAbbv;
    }

    public String getTeamAbbv() {
        return teamAbbv;
    }

    public void setRoster(Player[] roster) {
        this.roster = roster;
    }

    public Player[] getRoster() {
        return roster;
    }

    public void setHittingRoster(Player[] hittingRoster) {
        this.hittingRoster = hittingRoster;
    }

    public Player[] getHittingRoster() {
        return hittingRoster;
    }

    public void setPitchingRoster(Player[] pitchingRoster) {
        this.pitchingRoster = pitchingRoster;
    }

    public Player[] getPitchingRoster() {
        return pitchingRoster;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getWins() {
        return wins;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public int getLosses() {
        return losses;
    }

    public void setWinsAtHome(int winsAtHome) {
        this.winsAtHome = winsAtHome;
    }

    public int getWinsAtHome() {
        return winsAtHome;
    }

    public void setLossesAtHome(int lossesAtHome) {
        this.lossesAtHome = lossesAtHome;
    }

    public int getLossesAtHome() {
        return lossesAtHome;
    }

    public void setRunsScored(int runsScored) {
        this.runsScored = runsScored;
    }

    public int getRunsScored() {
        return runsScored;
    }

    public void setRunsAllowed(int runsAllowed) {
        this.runsAllowed = runsAllowed;
    }

    public int getRunsAllowed() {
        return runsAllowed;
    }

    // METHODS //

    public boolean equals(Team otherTeam) {
        if (this.hittingRoster == otherTeam.hittingRoster
                && this.pitchingRoster == otherTeam.pitchingRoster
                && this.wins == otherTeam.wins
                && this.losses == otherTeam.losses
                && this.winsAtHome == otherTeam.winsAtHome
                && this.lossesAtHome == otherTeam.lossesAtHome
                && this.runsScored == otherTeam.runsScored
                && this.runsAllowed == otherTeam.runsAllowed) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format(
                "Hitting Roster: %s%nPitching Roster: %s%nWins: %d | Losses: %d%nWins at Home: %d | Losses at Home: %d%nRuns Scored: %d | Runs Allowed: %d%n",
                hittingRoster.toString(), pitchingRoster.toString(), wins, losses, winsAtHome, lossesAtHome, runsScored, runsAllowed);
    }

    public int getRunDifferential() {
        return runsScored - runsAllowed;
    }

    public double getWinningPercentage() {
        return Math.roundDouble(wins / losses, 3);
    }

    public boolean addPlayerToRoster(Player player) {

        Player[] oldRoster = getRoster();
        int oldLength = oldRoster.length;

        Player[] updatedRoster = new Player[oldLength + 1];

        for (int i = 0; i < oldLength; i++) {
            if (oldRoster[i] == player || player == null) {
                return false;
            }
            updatedRoster[i] = oldRoster[i];
        }

        updatedRoster[oldLength] = player;
        setRoster(updatedRoster);
        return true;
    }

    public boolean removePlayerFromRoster(Player player) {

        Player[] oldRoster = getRoster();
        int oldLength = oldRoster.length;

        for (int i = 0; i < oldLength; i++) {
            if (oldRoster[i] == player) {

                Player[] updatedRoster = new Player[oldLength - 1];

                for (int k = 0; k < i; k++) {
                    updatedRoster[k] = oldRoster[k];
                }
                for (int k = i + 1; k < oldLength; k++) {
                    updatedRoster[k - 1] = oldRoster[k];
                }
                setRoster(updatedRoster);
                return true;
            }
        }
        return false;
    }

    public boolean swapRosterPosition(int posA, int posB) {

        Player[] roster = getRoster();
        int length = roster.length;

        if (posA < 0 || posB < 0 || posA >= length || posB >= length) {
            return false;
        }
        if (posA == posB) {
            return true;
        }

        Player temp = roster[posA];
        roster[posA] = roster[posB];
        roster[posB] = temp;
        setRoster(roster);
        return true;
    }

    public boolean pushRosterPosition(int from, int to) {

        Player[] roster = getRoster();
        int length = roster.length;

        if (from < 0 || to < 0 || from >= length || to >= length) {
            return false;
        }
        if (from == to) {
            return true;
        }

        Player[] updatedRoster = new Player[length];

        if (from > to) {

            for (int i = 0; i < to; i++) {
                updatedRoster[i] = roster[i];
            }

            updatedRoster[to] = roster[from];

            for (int i = to; i < from; i++) {
                updatedRoster[i + 1] = roster[i];
            }

            for (int i = from + 1; i < length; i++) {
                updatedRoster[i] = roster[i];
            }

        }

        if (from < to) {

            for (int i = 0; i < from; i++) {
                updatedRoster[i] = roster[i];
            }

            for (int i = from + 1; i < to; i++) {
                updatedRoster[i - 1] = roster[i];
            }

            updatedRoster[to] = roster[from];

            for (int i = to + 1; i < length; i++) {
                updatedRoster[i] = roster[i];
            }

        }

        setRoster(updatedRoster);
        return true;
    }

    public String[] getRosterNames() {

        String[] rosterNames = new String[roster.length];

        for (int i = 0; i < roster.length; i++) {
            rosterNames[i] = String.format("%s %s", roster[i].getFirstName(), roster[i].getLastName());
        }
        return rosterNames;
    }
}
