package cs112.ud3.UD2.Baseball;

/**
 * A MajorLeague designed to store Teams with special ordering and categorizing
 * rules.
 * 
 * @author Andrew Ibarra
 * @version 1.0
 * 
 *          - leagueName : String
 *          - leagueRoster : Team[]
 * 
 *          + MajorLeague()
 *          + MajorLeague(leagueName : String, leagueRoster : Team[])
 *          + MajorLeague(majorLeague : MajorLeague)
 * 
 *          + setLeagueName(leagueName : String) : void
 *          + getLeagueName() : String
 *          + setLeagueRoster(leagueRoster : Team[]) : void
 *          + getLeagueRoster() : Team[]
 * 
 *          + equals(otherTeam : Object) : boolean
 *          + toString() : String
 *          + getRunDifferential() : int
 *          + getWinningPercentage() : double
 *          + addTeamToRoster(player : Player) : boolean
 *          + removeTeamFromRoster(player : Player) : boolean
 *          + swapRosterPosition(posA : int, posB : int) : boolean
 *          + pushRosterPosition(from : int, to : int) : boolean
 *          + getLeagueRosterNames() : String[]
 * 
 */
public class MajorLeague {

    // INSTANCE VARIABLES //

    private String leagueName;
    private Team[] leagueRoster;

    // DEFAULT INSTANCE VARIABLES //

    private final String DEFAULT_LEAGUE_NAME = "None";
    private final Team[] DEFAULT_LEAGUE_ROSTER = new Team[] {};

    // CONSTRUCTORS //

    public MajorLeague() {
        setLeagueName(DEFAULT_LEAGUE_NAME);
        setLeagueRoster(DEFAULT_LEAGUE_ROSTER);
    }

    public MajorLeague(String leagueName, Team[] leagueRoster) {
        setLeagueName(leagueName);
        setLeagueRoster(leagueRoster);
    }

    public MajorLeague(MajorLeague league) {
        setLeagueName(league.getLeagueName());
        setLeagueRoster(league.getLeagueRoster());
    }

    // ACCESSORS & MUTATORS //

    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }

    public String getLeagueName() {
        return leagueName;
    }

    public void setLeagueRoster(Team[] leagueRoster) {
        this.leagueRoster = leagueRoster;
    }

    public Team[] getLeagueRoster() {
        return leagueRoster;
    }

    // METHODS //

    public boolean addTeamToRoster(Team team) {

        Team[] oldRoster = getLeagueRoster();
        int oldLength = oldRoster.length;

        Team[] updatedRoster = new Team[oldLength + 1];

        for (int i = 0; i < oldLength; i++) {
            if (oldRoster[i] == team || team == null) {
                return false;
            }
            updatedRoster[i] = oldRoster[i];
        }

        updatedRoster[oldLength] = team;
        setLeagueRoster(updatedRoster);
        return true;
    }

    public boolean removeTeamFromRoster(Team team) {

        Team[] oldRoster = getLeagueRoster();
        int oldLength = oldRoster.length;

        for (int i = 0; i < oldLength; i++) {
            if (oldRoster[i] == team) {

                Team[] updatedRoster = new Team[oldLength - 1];

                for (int k = 0; k < i; k++) {
                    updatedRoster[k] = oldRoster[k];
                }
                for (int k = i + 1; k < oldLength; k++) {
                    updatedRoster[k - 1] = oldRoster[k];
                }
                setLeagueRoster(updatedRoster);
                return true;
            }
        }
        return false;
    }

    public boolean swapRosterPosition(int posA, int posB) {

        Team[] roster = getLeagueRoster();
        int length = roster.length;

        if (posA < 0 || posB < 0 || posA >= length || posB >= length) {
            return false;
        }
        if (posA == posB) {
            return true;
        }

        Team temp = roster[posA];
        roster[posA] = roster[posB];
        roster[posB] = temp;
        setLeagueRoster(roster);
        return true;
    }

    public boolean pushRosterPosition(int from, int to) {

        Team[] roster = getLeagueRoster();
        int length = roster.length;

        if (from < 0 || to < 0 || from >= length || to >= length) {
            return false;
        }
        if (from == to) {
            return true;
        }

        Team[] updatedRoster = new Team[length];

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

        setLeagueRoster(updatedRoster);
        return true;
    }

    public String[] getLeagueRosterNames() {

        String[] rosterNames = new String[leagueRoster.length];

        for (int i = 0; i < leagueRoster.length; i++) {
            rosterNames[i] = String.format("%s %s", leagueRoster[i].getTeamCity(), leagueRoster[i].getTeamName());
        }
        return rosterNames;
    }
}
