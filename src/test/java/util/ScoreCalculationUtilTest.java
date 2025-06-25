package util;

import model.Match;
import model.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class ScoreCalculationUtilTest {

    @Nested
    @DisplayName("Points tests")
    class PointsTests {
        @Test
        void whenFirstPlayerHave0PointsAndWinPointThenPointsChangeTo15() {
            Player firstPlayer = new Player("Sergey");
            firstPlayer.setId(1);
            Player secondPlayer = new Player("Ilmira");
            secondPlayer.setId(2);

            Match match = new Match(firstPlayer, secondPlayer);
            firstPlayer.setPlayerPoints("0");
            ScoreCalculationUtil.scoreCalculation(firstPlayer.getId(), match);
            org.assertj.core.api.Assertions.assertThat(firstPlayer.getPlayerPoints()).as("15");
        }

        @Test
        void whenFirstPlayerHave15PointsAndWinPointThenPointsChangeTo30() {
            Player firstPlayer = new Player("Sergey");
            firstPlayer.setId(1);
            Player secondPlayer = new Player("Ilmira");
            secondPlayer.setId(2);

            Match match = new Match(firstPlayer, secondPlayer);
            firstPlayer.setPlayerPoints("15");
            ScoreCalculationUtil.scoreCalculation(firstPlayer.getId(), match);
            org.assertj.core.api.Assertions.assertThat(firstPlayer.getPlayerPoints()).as("30");
        }

        @Test
        void whenFirstPlayerHave30PointsAndWinPointThenPointsChangeTo40() {
            Player firstPlayer = new Player("Sergey");
            firstPlayer.setId(1);
            Player secondPlayer = new Player("Ilmira");
            secondPlayer.setId(2);

            Match match = new Match(firstPlayer, secondPlayer);
            firstPlayer.setPlayerPoints("30");
            ScoreCalculationUtil.scoreCalculation(firstPlayer.getId(), match);
            org.assertj.core.api.Assertions.assertThat(firstPlayer.getPlayerPoints()).as("40");
        }

        @Test
        void whenFirstPlayerHave40AndSecondPlayerHave40PointsAndFirstPlayerWinPointThenPointsChangeToAD() {
            Player firstPlayer = new Player("Sergey");
            firstPlayer.setId(1);
            Player secondPlayer = new Player("Ilmira");
            secondPlayer.setId(2);

            Match match = new Match(firstPlayer, secondPlayer);
            firstPlayer.setPlayerPoints("40");
            secondPlayer.setPlayerPoints("40");
            ScoreCalculationUtil.scoreCalculation(firstPlayer.getId(), match);
            org.assertj.core.api.Assertions.assertThat(firstPlayer.getPlayerPoints()).as("AD");
        }

        @Test
        void whenFirstPlayerHaveADAndFirstPlayerWinPointThenPointsChangeTo0AndFirstPlayerGamesChangeTo1AndPlayersPointsChangeTo0() {
            Player firstPlayer = new Player("Sergey");
            firstPlayer.setId(1);
            Player secondPlayer = new Player("Ilmira");
            secondPlayer.setId(2);

            Match match = new Match(firstPlayer, secondPlayer);
            firstPlayer.setPlayerPoints("AD");
            secondPlayer.setPlayerPoints("");
            ScoreCalculationUtil.scoreCalculation(firstPlayer.getId(), match);
            org.assertj.core.api.Assertions.assertThat(firstPlayer.getPlayerPoints()).as("0");
            org.assertj.core.api.Assertions.assertThat(secondPlayer.getPlayerPoints()).as("0");
            org.assertj.core.api.Assertions.assertThat(firstPlayer.getPlayerGames()).as("1");
            org.assertj.core.api.Assertions.assertThat(secondPlayer.getPlayerGames()).as("0");
        }

        @Test
        void whenFirstPlayerHaveADAndHaveGames1AndFirstPlayerWinPointThenPointsChangeTo0AndFirstPlayerGamesChangeTo2AndPlayersPointsChangeTo0() {
            Player firstPlayer = new Player("Sergey");
            firstPlayer.setId(1);
            Player secondPlayer = new Player("Ilmira");
            secondPlayer.setId(2);

            Match match = new Match(firstPlayer, secondPlayer);
            firstPlayer.setPlayerPoints("AD");
            secondPlayer.setPlayerPoints("");
            ScoreCalculationUtil.scoreCalculation(firstPlayer.getId(), match);
            org.assertj.core.api.Assertions.assertThat(firstPlayer.getPlayerPoints()).as("0");
            org.assertj.core.api.Assertions.assertThat(secondPlayer.getPlayerPoints()).as("0");
            org.assertj.core.api.Assertions.assertThat(firstPlayer.getPlayerGames()).as("2");
            org.assertj.core.api.Assertions.assertThat(secondPlayer.getPlayerGames()).as("0");
        }

        @Test
        void whenFirstPlayerHaveADAndSecondPlayerWinPointThenPointsChangeTo40() {
            Player firstPlayer = new Player("Sergey");
            firstPlayer.setId(1);
            Player secondPlayer = new Player("Ilmira");
            secondPlayer.setId(2);

            Match match = new Match(firstPlayer, secondPlayer);
            firstPlayer.setPlayerPoints("AD");
            secondPlayer.setPlayerPoints("");
            ScoreCalculationUtil.scoreCalculation(secondPlayer.getId(), match);
            org.assertj.core.api.Assertions.assertThat(firstPlayer.getPlayerPoints()).as("40");
            org.assertj.core.api.Assertions.assertThat(secondPlayer.getPlayerPoints()).as("40");
        }
    }
}
