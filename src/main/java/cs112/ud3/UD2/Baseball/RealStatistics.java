package cs112.ud3.UD2.Baseball;

/**
 * A storage class designed to keep real statistics from real MLB players,
 * provided by https://www.mlb.com/.
 * 
 * @author Andrew Ibarra
 * @version 1.0
 */
public abstract class RealStatistics {

        public static Player clement = new Player("Ernie", "Clement", 22, 3, 152),
                        guerrero = new Player("Vladimir", "Guerrero", 27, 1, 151),
                        bichette = new Player("Bo", "Bichette", 11, 5, 139),
                        springer = new Player("George", "Springer", 4, 9, 135),
                        straw = new Player("Myles", "Straw", 3, 7, 132),
                        lukes = new Player("Nathan", "Lukes", 38, 8, 131),
                        barger = new Player("Addison", "Barger", 47, 3, 130),
                        kirk = new Player("Alejandro", "Kirk", 30, 4, 126),
                        gimenez = new Player("Andrés", "Giménez", 0, 2, 97),
                        schneider = new Player("Davis", "Schneider", 36, 6, 79),
                        varsho = new Player("Daulton", "Varsho", 4, 9, 135),
                        hoffman = new Player("Jeff", "Hoffman", 23, 0, 69);
        static {
                // Hitters
                clement.hittingStats.setAll(528, 79, 146, 9, 47, 26, 60, 5, 5);
                guerrero.hittingStats.setAll(569, 94, 169, 23, 83, 81, 89, 6, 3);
                bichette.hittingStats.setAll(582, 78, 181, 18, 94, 40, 91, 4, 3);
                springer.hittingStats.setAll(480, 101, 147, 30, 80, 65, 107, 16, 0);
                straw.hittingStats.setAll(260, 50, 68, 4, 31, 18, 48, 12, 1);
                lukes.hittingStats.setAll(374, 54, 94, 11, 61, 38, 57, 2, 4);
                barger.hittingStats.setAll(447, 58, 109, 20, 72, 32, 117, 4, 1);
                kirk.hittingStats.setAll(435, 42, 123, 12, 69, 48, 55, 1, 0);
                gimenez.hittingStats.setAll(318, 38, 66, 7, 33, 24, 63, 12, 2);
                schneider.hittingStats.setAll(183, 31, 44, 11, 31, 33, 59, 3, 1);
                varsho.hittingStats.setAll(480, 101, 147, 30, 80, 65, 107, 16, 0);
                // Pitchers
                hoffman.pitchingStats.setAll(9, 7, 66, 34, 15, 24, 83, 0.215);
        }

    public static Team 
            blueJays = new Team("Toronto", "Blue Jays", "TO",
            new Player[] { clement, guerrero, bichette, springer, straw, lukes, barger, kirk, gimenez, schneider,
                    varsho, hoffman }, 90, 67, 50, 26, 769, 706),
                            yankees = new Team("New York", "Yankees", "NY", new Player[] {}, 89, 68, 45, 31, 819,
                                    674),
            redSocks = new Team("Boston", "Red Socks", "BO", new Player[] {}, 86, 71, 46, 32, 769,
                    661),
            rays = new Team("Tampa Bay", "Rays", "TB", new Player[] {}, 76, 81, 41, 40, 696, 653),
            orioles = new Team("Baltimore", "Orioles", "BA", new Player[] {}, 74, 83, 38, 41,
                            662, 760),
            guardians = new Team("Cleveland", "Guardians", "CL", new Player[] {}, 85, 72, 42, 34, 621,
                            627),
            tigers = new Team("Detroit", "Tigers", "DE", new Player[] {}, 85, 72, 46, 35, 745, 675),
            royals = new Team("Kansas City", "Royals", "KC", new Player[] {}, 79, 78, 43, 38, 624,
                            622),
            twins = new Team("Minnessota", "Twins", "MN", new Player[] {}, 68, 89, 38, 43, 665,
                            764),
            whiteSocks = new Team("Chicago", "White Socks", "CH", new Player[] {}, 58, 99, 33, 48, 620,
                            714),
            mariners = new Team("Seattle", "Mariners", "SE", new Player[] {}, 88, 69, 49, 27, 745,
                            676),
            astros = new Team("Houston", "Astros", "HO", new Player[] {}, 84, 73, 46, 35, 660, 647),
            rangers = new Team("Texas", "Rangers", "TX", new Player[] {}, 79, 78, 47, 32, 663, 584),
            athletics = new Team("Sacramento", "Athletics", "SA", new Player[] {}, 74, 83, 34, 42, 714,
                            790),
            angels = new Team("Los Angeles", "Angels", "LA", new Player[] {}, 70, 87, 37, 39, 659,
                            881),
            phillies = new Team("Philadelphia", "Phillies", "PH", new Player[] {}, 92, 65, 51, 25, 761,
                            640),
            mets = new Team("New York", "Mets", "NY", new Player[] {}, 81, 76, 49, 32, 748, 690),
            marlins = new Team("Miami", "Marlins", "MI", new Player[] {}, 77, 80, 36, 42, 698, 779),
            braves = new Team("Atlanta", "Braves", "AT", new Player[] {}, 75, 84, 38, 40, 716, 721),
            nationals = new Team("Washington", "Nationals", "WA", new Player[] {}, 65, 94, 31, 47, 672,
                            876),
            brewers = new Team("Milwaukee", "Brewers", "ML", new Player[] {}, 95, 63, 51, 27, 794,
                            621),
            cubs = new Team("Chicago", "Cubs", "CH", new Player[] {}, 88, 69, 46, 30, 757, 634),
            reds = new Team("Cincinnati", "Reds", "CN", new Player[] {}, 80, 77, 44, 35, 699, 667),
            cardinals = new Team("St. Louis", "Cardinals", "SL", new Player[] {}, 78, 80, 44, 37, 682,
                            729),
            pirates = new Team("Pittsburgh", "Pirates", "PT", new Player[] {}, 68, 89, 44, 37, 565,
                            632),
            dodgers = new Team("Los Angeles", "Dodgers", "LA", new Player[] {}, 88, 69, 52, 29, 798,
                            673),
            padres = new Team("San Diego", "Padres", "SD", new Player[] {}, 87, 71, 49, 28, 677,
                            609),
            diamondbacks = new Team("Arizona", "Diamondbacks", "AZ", new Player[] {}, 80, 77, 43, 36, 778,
                            748),
            giants = new Team("San Francisco", "Giants", "SF", new Player[] {}, 77, 81, 38, 39, 687,
                            675),
            rockies = new Team("Colorado", "Rockies", "CO", new Player[] {}, 43, 114, 25, 56, 587,
                            992);

            public static MajorLeague
            allTeams = new MajorLeague("All Teams", new Team[] { blueJays, yankees, redSocks, rays, orioles, guardians, tigers, royals, twins, whiteSocks, mariners, astros, rangers, athletics, angels, phillies, mets, marlins, braves, nationals, brewers, cubs, reds, cardinals, pirates, dodgers, padres, diamondbacks, giants, rockies }),
            americanLeagueEast = new MajorLeague("American League East", new Team[] { blueJays, yankees, redSocks, rays, orioles }),
            americanLeagueCentral = new MajorLeague("American League Central", new Team[] { guardians, tigers, royals, twins, whiteSocks }),
            americanLeagueWest = new MajorLeague("American League West", new Team[] { mariners, astros, rangers, athletics, angels }),
            nationalLeagueEast = new MajorLeague("National League East", new Team[] { phillies, mets, marlins, braves, nationals }),
            nationalLeagueCentral = new MajorLeague("National League Central", new Team[] { brewers, cubs, reds, cardinals, pirates }),
            nationalLeagueWest = new MajorLeague("National League West", new Team[] { dodgers, padres, diamondbacks, giants, rockies });
}
