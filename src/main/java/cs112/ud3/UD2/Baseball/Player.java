package cs112.ud3.UD2.Baseball;

/**
 * A player designed to be on a team and interact in a game. Hitting/Pitching
 * class variables are designed to change as the game progresses.
 * 
 * @author Andrew Ibarra
 * @version 1.0
 *          # firstName : String
 *          # lastName : String
 *          # primaryNumber : int
 *          # position : int
 *          # gamesPlayed : int
 *          # hittingStats : Hitting
 *          # pitchingStats : Pitching
 * 
 *          + Player()
 *          + Player(firstName : String, lastName : String, primaryNumber : int,
 *          position : int, gamesPlayed : int)
 *          + Player(player : Player)
 * 
 *          + setGamesPlayed(gamesPlayed : int) : void
 *          + getGamesPlayed() : int
 *          + setFirstName(firstName : String) : void
 *          + getFirstName() : String
 *          + setLastName(lastName : String) : void
 *          + getLastName() : String
 *          + setPrimaryNumber(primaryNumber : int) : void
 *          + getPrimaryNumber() : int
 *          + setPosition(position : int) : boolean
 *          + getPosition() : int
 * 
 *          + setHittingStats(hittingStats : Hitting) : void
 *          + getHittingStats() : Hitting
 *          + setAtBats(atBats : int) : void
 *          + getAtBats() : int
 *          + setRuns(runs : int) : void
 *          + getRuns() : integer
 *          + setHits(hits : int) : void
 *          + getHits() : int
 *          + setHomeRuns(homeRuns : int) : void
 *          + getHomeRuns() : int
 *          + setRunsBattedIn(runsBattedIn : int) : void
 *          + getRunsBattedIn() : int
 *          + setWalks(walks : int) : void
 *          + getWalks() : int
 *          + setStrikeouts(strikeouts : int) : void
 *          + getStrikeouts() : int
 *          + setStolenBases(stolenBases : int) : void
 *          + getStolenBases() : int
 *          + setCaughtStealing(caughtStealing : int) : void
 *          + getCaughtStealing() : int
 * 
 *          + setPitchingStats(pitchingStats : Pitching) : void
 *          + getPitchingStats() : Pitching
 *          + setCreditedWins(creditedWins : int) : void
 *          + getCreditedWins() : int
 *          + setCreditedLosses(creditedLosses : int) : void
 *          + getCreditedLosses() : int
 *          + setInningsPitched(inningsPitched : int) : void
 *          + getInningsPitched() : int
 *          + setRunsPitching(runsPitching : int) : void
 *          + getRunsPitching() : int
 *          + setHomeRunsPitching(homeRunsPitching : int) : void
 *          + getHomeRunsPitching() : int
 *          + setWalksPitching(walksPitching : int) : void
 *          + getWalksPitching() : int
 *          + setStrikeoutsPitching(strikeoutsPitching : int) : void
 *          + getStrikeoutsPitching() : int
 *          + setBattingAgainstAverage(battingAgainstAverage : double) : void
 *          + getBattingAgainstAverage() : double
 * 
 *          + equals(otherPlayer : Object) : boolean
 *          + toString() : String
 *          + initializeHitter() : void
 *          + initializePitcher() : void
 * 
 */
public class Player {

    // INSTANCE VARIABLES //

    protected String firstName, lastName;
    protected int primaryNumber, position, gamesPlayed;
    protected Hitting hittingStats;
    protected Pitching pitchingStats;

    // DEFAULT INSTANCE VARIABLES //

    private final String DEFAULT_FIRST_NAME = "None", DEFAULT_LAST_NAME = "None";
    private final int DEFAULT_PRIMARY_NUMBER = -1, DEFAULT_POSITION = -1, DEFAULT_GAMES_PLAYED = 0;
    private final Hitting DEFAULT_HITTING_STATS = null;
    private final Pitching DEFAULT_PITCHING_STATS = null;

    // CONSTRUCTORS //

    public Player() {
        setFirstName(DEFAULT_FIRST_NAME);
        setLastName(DEFAULT_LAST_NAME);
        setPrimaryNumber(DEFAULT_PRIMARY_NUMBER);
        setPosition(DEFAULT_POSITION);
        setGamesPlayed(DEFAULT_GAMES_PLAYED);
        setHittingStats(DEFAULT_HITTING_STATS);
        setPitchingStats(DEFAULT_PITCHING_STATS);
    }

    public Player(String firstName, String lastName, int primaryNumber,
            int position, int gamesPlayed) {
        setFirstName(firstName);
        setLastName(lastName);
        setPrimaryNumber(primaryNumber);
        setPosition(position);
        setGamesPlayed(gamesPlayed);
    }

    public Player(Player player) {
        setFirstName(player.getFirstName());
        setLastName(player.getLastName());
        setPrimaryNumber(player.getPrimaryNumber());
        setPosition(player.getPosition());
        setGamesPlayed(player.getGamesPlayed());
        if (player.getPosition() == 0) {
            initializePitcher();
            setPitchingStats(player.getPitchingStats());
        }
        if (player.getPosition() != 0) {
            initializeHitter();
            setHittingStats(player.getHittingStats());
        }
    }

    // ACCESSORS & MUTATORS //

    // Player class exclusive
    public void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setPrimaryNumber(int primaryNumber) {
        this.primaryNumber = primaryNumber;
    }

    public int getPrimaryNumber() {
        return primaryNumber;
    }

    /*
     * POSITIONS:
     * -1 - Not in Play (N/A)
     * 0 - Pitcher (P)
     * 1 - First Base (1B)
     * 2 - Second Base (2B)
     * 3 - Third Base (3B)
     * 4 - Catcher (C)
     * 5 - Shortstop (SS)
     * 6 - Left Field (LF)
     * 7 - Center Field (CF)
     * 8 - Right Field (RF)
     * 9 - Designated Hitter (DH)
     */
    public boolean setPosition(int position) {
        if (-1 <= position && position <= 9) {
            this.position = position;
            if (position == 0) {
                initializePitcher();
            }
            if (position != 0) {
                initializeHitter();
            }
            return true;
        }
        return false;
    }

    public int getPosition() {
        return position;
    }

    // Hitting class
    public void setHittingStats(Hitting hittingStats) {
        this.hittingStats = hittingStats;
    }

    public Hitting getHittingStats() {
        return hittingStats;
    }

    public void setAtBats(int atBats) {
        this.hittingStats.atBats = atBats;
    }

    public int getAtBats() {
        return hittingStats.atBats;
    }

    public void setRuns(int runs) {
        this.hittingStats.runs = runs;
    }

    public int getRuns() {
        return hittingStats.runs;
    }

    public void setHits(int hits) {
        this.hittingStats.hits = hits;
    }

    public int getHits() {
        return hittingStats.hits;
    }

    public void setHomeRuns(int homeRuns) {
        this.hittingStats.homeRuns = homeRuns;
    }

    public int getHomeRuns() {
        return hittingStats.homeRuns;
    }

    public void setRunsBattedIn(int runsBattedIn) {
        this.hittingStats.runsBattedIn = runsBattedIn;
    }

    public int getRunsBattedIn() {
        return hittingStats.runsBattedIn;
    }

    public void setWalks(int walks) {
        this.hittingStats.walks = walks;
    }

    public int getWalks() {
        return hittingStats.walks;
    }

    public void setStrikeouts(int strikeouts) {
        this.hittingStats.strikeouts = strikeouts;
    }

    public int getStrikeouts() {
        return hittingStats.strikeouts;
    }

    public void setStolenBases(int stolenBases) {
        this.hittingStats.stolenBases = stolenBases;
    }

    public int getStolenBases() {
        return hittingStats.stolenBases;
    }

    public void setCaughtStealing(int caughtStealing) {
        this.hittingStats.caughtStealing = caughtStealing;
    }

    public int getCaughtStealing() {
        return hittingStats.caughtStealing;
    }

    // Pitching class
    public void setPitchingStats(Pitching pitchingStats) {
        this.pitchingStats = pitchingStats;
    }

    public Pitching getPitchingStats() {
        return pitchingStats;
    }

    public void setCreditedWins(int creditedWins) {
        this.pitchingStats.creditedWins = creditedWins;
    }

    public int getCreditedWins() {
        return pitchingStats.creditedWins;
    }

    public void setCreditedLosses(int creditedLosses) {
        this.pitchingStats.creditedLosses = creditedLosses;
    }

    public int getCreditedLosses() {
        return pitchingStats.creditedLosses;
    }

    public void setInningsPitched(int inningsPitched) {
        this.pitchingStats.inningsPitched = inningsPitched;
    }

    public int getInningsPitched() {
        return pitchingStats.inningsPitched;
    }

    public void setRunsPitching(int runs) {
        this.pitchingStats.runs = runs;
    }

    public int getRunsPitching() {
        return pitchingStats.runs;
    }

    public void setHomeRunsPitching(int homeRuns) {
        this.pitchingStats.homeRuns = homeRuns;
    }

    public int getHomeRunsPitching() {
        return pitchingStats.homeRuns;
    }

    public void setWalksPitching(int walks) {
        this.pitchingStats.walks = walks;
    }

    public int getWalksPitching() {
        return pitchingStats.walks;
    }

    public void setStrikeoutsPitching(int strikeouts) {
        this.pitchingStats.strikeouts = strikeouts;
    }

    public int getStrikeoutsPitching() {
        return pitchingStats.strikeouts;
    }

    public void setBattingAgainstAverage(double battingAgainstAverage) {
        this.pitchingStats.battingAgainstAverage = battingAgainstAverage;
    }

    public double getBattingAgainstAverage() {
        return pitchingStats.battingAgainstAverage;
    }

    // METHODS //

    @Override
    public boolean equals(Object otherPlayer) {
        if (otherPlayer == null || !(otherPlayer instanceof Player)) {
            return false;
        }
        Player temp = (Player) otherPlayer;

        boolean playerTypeConditions = false;
        boolean playerConditions = (this.firstName == temp.firstName && this.lastName == temp.lastName
                && this.primaryNumber == temp.primaryNumber && this.position == temp.position
                && this.gamesPlayed == temp.gamesPlayed);

        if ((this.hittingStats != null) && (this.pitchingStats == null
                && temp.pitchingStats == null)) {
            playerTypeConditions = this.hittingStats.equals(temp.hittingStats);
        }
        if ((this.pitchingStats != null) && (this.hittingStats == null && temp.hittingStats == null)) {
            playerTypeConditions = this.pitchingStats.equals(temp.pitchingStats);
        }
        return playerConditions && playerTypeConditions;
    }

    @Override
    public String toString() {
        String playerSpecificStats = "No player record";
        if (this.pitchingStats != null && this.hittingStats == null) {
            playerSpecificStats = this.pitchingStats.toString();
        }
        if (this.pitchingStats == null && this.hittingStats != null) {
            playerSpecificStats = this.hittingStats.toString();
        }
        return String.format("%s %s #%d%nGames Played: %d%n%s%n", firstName, lastName, primaryNumber, gamesPlayed,
                playerSpecificStats);
    }

    public void initializeHitter() {
        this.pitchingStats = null;
        this.hittingStats = new Hitting();
    }

    public void initializePitcher() {
        this.hittingStats = null;
        this.pitchingStats = new Pitching();
    }

    // CLASSES //

    public class Hitting {

        // INSTANCE VARIABLES //

        private int atBats, runs, hits, homeRuns, runsBattedIn, walks, strikeouts, stolenBases, caughtStealing;

        // DEFAULT INSTANCE VARIABLES //

        private final int DEFAULT_AT_BATS = 0, DEFAULT_RUNS = 0, DEFAULT_HITS = 0,
                DEFUALT_HOME_RUNS = 0, DEFAULT_RUNS_BATTED_IN = 0, DEFAULT_WALKS = 0, DEFAULT_STRIKEOUTS = 0,
                DEFAULT_STOLEN_BASES = 0, DEFAULT_CAUGHT_STEALING = 0;

        // CONSTRUCTORS //

        public Hitting() {
            this.atBats = DEFAULT_AT_BATS;
            this.runs = DEFAULT_RUNS;
            this.hits = DEFAULT_HITS;
            this.homeRuns = DEFUALT_HOME_RUNS;
            this.runsBattedIn = DEFAULT_RUNS_BATTED_IN;
            this.walks = DEFAULT_WALKS;
            this.strikeouts = DEFAULT_STRIKEOUTS;
            this.stolenBases = DEFAULT_STOLEN_BASES;
            this.caughtStealing = DEFAULT_CAUGHT_STEALING;
        }

        public Hitting(int atBats, int runs, int hits, int homeRuns,
                int runsBattedIn, int walks, int strikeouts, int stolenBases, int caughtStealing) {
            setAtBats(atBats);
            setRuns(runs);
            setHits(hits);
            setHomeRuns(homeRuns);
            setRunsBattedIn(runsBattedIn);
            setWalks(walks);
            setStrikeouts(strikeouts);
            setStolenBases(stolenBases);
            setCaughtStealing(caughtStealing);
        }

        public Hitting(Hitting hitter) {
            this.atBats = hitter.atBats;
            this.runs = hitter.runs;
            this.hits = hitter.hits;
            this.homeRuns = hitter.homeRuns;
            this.runsBattedIn = hitter.runsBattedIn;
            this.walks = hitter.walks;
            this.strikeouts = hitter.strikeouts;
            this.stolenBases = hitter.stolenBases;
            this.caughtStealing = hitter.caughtStealing;
        }

        // METHODS //

        public void setAll(int atBats, int runs, int hits, int homeRuns,
                int runsBattedIn, int walks, int strikeouts, int stolenBases, int caughtStealing) {
            setAtBats(atBats);
            setRuns(runs);
            setHits(hits);
            setHomeRuns(homeRuns);
            setRunsBattedIn(runsBattedIn);
            setWalks(walks);
            setStrikeouts(strikeouts);
            setStolenBases(stolenBases);
            setCaughtStealing(caughtStealing);
        }

        @Override
        public boolean equals(Object otherHittingStats) {
            if (otherHittingStats == null || !(otherHittingStats instanceof Hitting)) {
                return false;
            }
            Hitting temp = (Hitting) otherHittingStats;
            return (this.atBats == temp.atBats && this.runs == temp.runs && this.hits == temp.hits
                    && this.homeRuns == temp.homeRuns && this.runsBattedIn == temp.runsBattedIn
                    && this.walks == temp.walks && this.strikeouts == temp.strikeouts
                    && this.stolenBases == temp.stolenBases && this.caughtStealing == temp.caughtStealing);
        }

        @Override
        public String toString() {
            return String.format(
                    "Hitting Stats: [AB: %d, R: %d, H: %d, HR: %d, RBI: %d, W: %d, SO: %d, SB: %d, CS: %d]", atBats,
                    runs, hits, homeRuns, runsBattedIn, walks, strikeouts, stolenBases, caughtStealing);
        }

    }

    public class Pitching {

        // INSTANCE VARIABLES //

        private int creditedWins, creditedLosses, inningsPitched, runs, homeRuns, walks, strikeouts;
        private double battingAgainstAverage;

        // DEFAULT INSTANCE VARIABLES //

        private final int DEFAULT_CREDITED_WINS = 0, DEFAULT_CREDITED_LOSSES = 0, DEFAULT_INNINGS_PITCHED = 0,
                DEFAULT_RUNS = 0, DEFAULT_HOME_RUNS = 0, DEFAULT_WALKS = 0, DEFAULT_STRIKEOUTS = 0;
        private final double DEFAULT_BATTING_AGAINST_AVERAGE = 0.000;

        // CONSTRUCTORS //

        public Pitching() {
            this.creditedWins = DEFAULT_CREDITED_WINS;
            this.creditedLosses = DEFAULT_CREDITED_LOSSES;
            this.inningsPitched = DEFAULT_INNINGS_PITCHED;
            this.runs = DEFAULT_RUNS;
            this.homeRuns = DEFAULT_HOME_RUNS;
            this.walks = DEFAULT_WALKS;
            this.strikeouts = DEFAULT_STRIKEOUTS;
            this.battingAgainstAverage = DEFAULT_BATTING_AGAINST_AVERAGE;
        }

        public Pitching(int creditedWins, int creditedLosses, int inningsPitched, int runs,
                int homeRuns, int walks, int strikeouts, double battingAgainstAverage) {
            setCreditedWins(creditedWins);
            setCreditedLosses(creditedLosses);
            setInningsPitched(inningsPitched);
            setRunsPitching(runs);
            setHomeRunsPitching(homeRuns);
            setWalksPitching(walks);
            setStrikeoutsPitching(strikeouts);
            setBattingAgainstAverage(battingAgainstAverage);

        }

        public Pitching(Pitching pitcher) {
            this.creditedWins = pitcher.creditedWins;
            this.creditedLosses = pitcher.creditedLosses;
            this.inningsPitched = pitcher.inningsPitched;
            this.runs = pitcher.runs;
            this.homeRuns = pitcher.homeRuns;
            this.walks = pitcher.walks;
            this.strikeouts = pitcher.strikeouts;
            this.battingAgainstAverage = pitcher.battingAgainstAverage;
        }

        // METHODS //

        public void setAll(int creditedWins, int creditedLosses, int inningsPitched, int runs,
                int homeRuns, int walks, int strikeouts, double battingAgainstAverage) {
            setCreditedWins(creditedWins);
            setCreditedLosses(creditedLosses);
            setInningsPitched(inningsPitched);
            setRunsPitching(runs);
            setHomeRunsPitching(homeRuns);
            setWalksPitching(walks);
            setStrikeoutsPitching(strikeouts);
            setBattingAgainstAverage(battingAgainstAverage);
        }

        @Override
        public boolean equals(Object otherPitchingStats) {
            if (otherPitchingStats == null || !(otherPitchingStats instanceof Pitching)) {
                return false;
            }
            Pitching temp = (Pitching) otherPitchingStats;
            return (this.creditedWins == temp.creditedWins && this.creditedLosses == temp.creditedLosses
                    && this.inningsPitched == temp.inningsPitched
                    && this.runs == temp.runs && this.homeRuns == temp.homeRuns
                    && this.walks == temp.walks && this.strikeouts == temp.strikeouts
                    && this.battingAgainstAverage == temp.battingAgainstAverage);
        }

        @Override
        public String toString() {
            return String.format(
                    "Pitcing Stats: [CW: %d, CL: %d, IP: %d, R: %d, HR: %d, W: %d, SO: %d, BA: %.3f]", creditedWins,
                    creditedLosses, inningsPitched, runs, homeRuns, walks, strikeouts, battingAgainstAverage);
        }

    }

}