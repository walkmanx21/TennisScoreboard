package util;

import model.Match;
import model.Player;
import org.junit.jupiter.api.*;

public class ScoreCalculationUtilTest {

    private model.Player firstPlayer;
    private model.Player secondPlayer;
    private model.Match match;

    @BeforeEach
    void setMatch() {
        firstPlayer = new Player("Sergey");
        firstPlayer.setId(1);
        secondPlayer = new model.Player("Ilmira");
        secondPlayer.setId(2);
        match = new Match(firstPlayer, secondPlayer);
    }

    @Nested
    @DisplayName("Points tests")
    class PointsTests {

        @Test
        void whenFirstPlayerHave0PointsAndWinPointThenPointsChangeTo15() {
            firstPlayer.setPlayerPoints("0");
            ScoreCalculationUtil.scoreCalculation(firstPlayer.getId(), match);
            Assertions.assertEquals("15", firstPlayer.getPlayerPoints());
        }

        @Test
        void whenSecondPlayerHave0PointsAndWinPointThenPointsChangeTo15() {
            firstPlayer.setPlayerPoints("0");
            ScoreCalculationUtil.scoreCalculation(secondPlayer.getId(), match);
            Assertions.assertEquals("15", secondPlayer.getPlayerPoints());
        }

        @Test
        void whenFirstPlayerHave15PointsAndWinPointThenPointsChangeTo30() {
            firstPlayer.setPlayerPoints("15");
            ScoreCalculationUtil.scoreCalculation(firstPlayer.getId(), match);
            Assertions.assertEquals("30", firstPlayer.getPlayerPoints());
        }

        @Test
        void whenFirstPlayerHave30PointsAndWinPointThenPointsChangeTo40() {
            firstPlayer.setPlayerPoints("30");
            ScoreCalculationUtil.scoreCalculation(firstPlayer.getId(), match);
            Assertions.assertEquals("40", firstPlayer.getPlayerPoints());
        }

        @Test
        void whenFirstPlayerHave40AndSecondPlayerHave40PointsAndFirstPlayerWinPointThenPointsChangeToAD() {
            firstPlayer.setPlayerPoints("40");
            secondPlayer.setPlayerPoints("40");
            ScoreCalculationUtil.scoreCalculation(firstPlayer.getId(), match);
            Assertions.assertEquals("AD", firstPlayer.getPlayerPoints());
        }

        @Test
        void whenFirstPlayerHaveADAndFirstPlayerWinPointThenPointsChangeTo0AndFirstPlayerGamesChangeTo1AndPlayersPointsChangeTo0() {
            firstPlayer.setPlayerPoints("AD");
            secondPlayer.setPlayerPoints("");
            ScoreCalculationUtil.scoreCalculation(firstPlayer.getId(), match);
            Assertions.assertEquals("0", firstPlayer.getPlayerPoints());
            Assertions.assertEquals("0", secondPlayer.getPlayerPoints());
            Assertions.assertEquals(1, firstPlayer.getPlayerGames());
            Assertions.assertEquals(0, secondPlayer.getPlayerGames());
        }

        @Test
        void whenFirstPlayerHaveADAndHaveGames1AndFirstPlayerWinPointThenPointsChangeTo0AndFirstPlayerGamesChangeTo2AndPlayersPointsChangeTo0() {
            firstPlayer.setPlayerPoints("AD");
            secondPlayer.setPlayerPoints("");
            firstPlayer.setPlayerGames(1);
            ScoreCalculationUtil.scoreCalculation(firstPlayer.getId(), match);
            Assertions.assertEquals("0", firstPlayer.getPlayerPoints());
            Assertions.assertEquals("0", secondPlayer.getPlayerPoints());
            Assertions.assertEquals(2, firstPlayer.getPlayerGames());
            Assertions.assertEquals(0, secondPlayer.getPlayerGames());
        }

        @Test
        void whenFirstPlayerHaveADAndSecondPlayerWinPointThenPointsChangeTo40() {
            firstPlayer.setPlayerPoints("AD");
            secondPlayer.setPlayerPoints("");
            ScoreCalculationUtil.scoreCalculation(secondPlayer.getId(), match);
            Assertions.assertEquals("40", firstPlayer.getPlayerPoints());
            Assertions.assertEquals("40", secondPlayer.getPlayerPoints());
        }
    }

    @Nested
    @DisplayName("GamesTests")
    class GamesTests {

        @BeforeEach
        void setPoints() {
            firstPlayer.setPlayerPoints("AD");
            secondPlayer.setPlayerPoints("");
        }

        @Test
        void whenFirstPlayerHaveADAndFirstPlayerWinPointThenPointsChangeTo0AndFirstPlayerGamesChangeTo1AndPlayersPointsChangeTo0() {
            ScoreCalculationUtil.scoreCalculation(firstPlayer.getId(), match);
            Assertions.assertEquals("0", firstPlayer.getPlayerPoints());
            Assertions.assertEquals("0", secondPlayer.getPlayerPoints());
            Assertions.assertEquals(1, firstPlayer.getPlayerGames());
            Assertions.assertEquals(0, secondPlayer.getPlayerGames());
        }

        @Test
        void whenFirstPlayerHave5Games0SetsAndWinGameAndSecondPlayerHave4GamesThenGamesChangeTo0AndFirstPlayerSetChangeTo1() {
            firstPlayer.setPlayerGames(5);
            secondPlayer.setPlayerGames(4);
            firstPlayer.setPlayerSets(0);
            ScoreCalculationUtil.scoreCalculation(firstPlayer.getId(), match);
            Assertions.assertEquals("0", firstPlayer.getPlayerPoints());
            Assertions.assertEquals("0", secondPlayer.getPlayerPoints());
            Assertions.assertEquals(0, firstPlayer.getPlayerGames());
            Assertions.assertEquals(0, secondPlayer.getPlayerGames());
            Assertions.assertEquals(1, firstPlayer.getPlayerSets());
            Assertions.assertEquals(0, secondPlayer.getPlayerSets());
        }

        @Test
        void whenFirstPlayerHave6Games0SetsAndSecondPlayerHave5GamesAndFirstPlayerWinGameThenFirstPlayerSetChangeTo1() {
            firstPlayer.setPlayerGames(6);
            secondPlayer.setPlayerGames(5);
            firstPlayer.setPlayerSets(0);
            ScoreCalculationUtil.scoreCalculation(firstPlayer.getId(), match);
            Assertions.assertEquals("0", firstPlayer.getPlayerPoints());
            Assertions.assertEquals("0", secondPlayer.getPlayerPoints());
            Assertions.assertEquals(0, firstPlayer.getPlayerGames());
            Assertions.assertEquals(0, secondPlayer.getPlayerGames());
            Assertions.assertEquals(1, firstPlayer.getPlayerSets());
            Assertions.assertEquals(0, secondPlayer.getPlayerSets());
        }

        @Nested
        class Tiebreak {
            @BeforeEach
            void setGames() {
                firstPlayer.setPlayerGames(6);
                secondPlayer.setPlayerGames(6);
            }

            @Test
            void whenFirstPlayerHave0PointsAndFirstPlayerWinPointThenFirstPlayerPointChangeTo1() {
                firstPlayer.setPlayerPoints("0");
                secondPlayer.setPlayerPoints("0");
                ScoreCalculationUtil.scoreCalculation(firstPlayer.getId(), match);
                Assertions.assertEquals("1", firstPlayer.getPlayerPoints());
            }

            @Test
            void whenFirstPlayerHave6PointsAndSecondPlayerHave5PointsAndFirstPlayerWinPointThenFirstPlayerWinSet() {
                firstPlayer.setPlayerPoints("6");
                secondPlayer.setPlayerPoints("5");
                firstPlayer.setPlayerSets(0);
                ScoreCalculationUtil.scoreCalculation(firstPlayer.getId(), match);
                Assertions.assertEquals("0", firstPlayer.getPlayerPoints());
                Assertions.assertEquals("0", secondPlayer.getPlayerPoints());
                Assertions.assertEquals(0, secondPlayer.getPlayerGames());
                Assertions.assertEquals(0, secondPlayer.getPlayerGames());
                Assertions.assertEquals(1, firstPlayer.getPlayerSets());
            }

            @Test
            void whenFirstPlayerHave6PointsAndSecondPlayerHave0PointsAndFirstPlayerWinPointThenFirstPlayerWinSet() {
                firstPlayer.setPlayerPoints("6");
                secondPlayer.setPlayerPoints("0");
                firstPlayer.setPlayerSets(0);
                ScoreCalculationUtil.scoreCalculation(firstPlayer.getId(), match);
                Assertions.assertEquals("0", firstPlayer.getPlayerPoints());
                Assertions.assertEquals("0", secondPlayer.getPlayerPoints());
                Assertions.assertEquals(0, secondPlayer.getPlayerGames());
                Assertions.assertEquals(0, secondPlayer.getPlayerGames());
                Assertions.assertEquals(1, firstPlayer.getPlayerSets());
            }

            @Test
            void whenFirstPlayerHave20PointsAndSecondPlayerHave19PointsAndFirstPlayerWinPointThenFirstPlayerWinSet() {
                firstPlayer.setPlayerPoints("20");
                secondPlayer.setPlayerPoints("19");
                firstPlayer.setPlayerSets(0);
                ScoreCalculationUtil.scoreCalculation(firstPlayer.getId(), match);
                Assertions.assertEquals("0", firstPlayer.getPlayerPoints());
                Assertions.assertEquals("0", secondPlayer.getPlayerPoints());
                Assertions.assertEquals(0, secondPlayer.getPlayerGames());
                Assertions.assertEquals(0, secondPlayer.getPlayerGames());
                Assertions.assertEquals(1, firstPlayer.getPlayerSets());
            }
        }
    }
}
