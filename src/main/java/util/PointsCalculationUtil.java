package util;

import matchScore.CurrentMatchScore;
import model.Match;
import model.Player;

public final class PointsCalculationUtil {

    private PointsCalculationUtil(){}

    public static void scoreCalculation(Integer playerWinPointId, Match match) {
        Player firstPlayer = match.getFirstPlayer();
        Player secondPlayer = match.getSecondPlayer();
        Player playerWinPoint;
        playerWinPoint = firstPlayer.getId().equals(playerWinPointId) ? firstPlayer : secondPlayer;

        if (playerWinPoint.equals(firstPlayer)) {
            pointsCalculation(firstPlayer, secondPlayer);
        } else {
            pointsCalculation(secondPlayer, firstPlayer);
        }
    }

    private static void pointsCalculation(Player winnerPlayer, Player loosingPlayer) {
        String winnerPlayerPoints = winnerPlayer.getPlayerPoints();
        String loosingPlayerPoints = loosingPlayer.getPlayerPoints();
        int winnerPlayerGames = winnerPlayer.getPlayerGames();
        switch (winnerPlayerPoints) {
            case("0"):
                winnerPlayer.setPlayerPoints("15");
                break;
            case("15"):
                winnerPlayer.setPlayerPoints("30");
                break;
            case("30"):
                winnerPlayer.setPlayerPoints("40");
                break;
            case("40"):
                if (!loosingPlayerPoints.equals("40")) {
                    winnerPlayer.setPlayerGames(winnerPlayerGames + 1);
                    winnerPlayer.setPlayerPoints("0");
                    loosingPlayer.setPlayerPoints("0");
                } else {
                    winnerPlayer.setPlayerPoints("AD");
                    loosingPlayer.setPlayerPoints("");
                }
                break;
            case("AD"):
                winnerPlayer.setPlayerGames(winnerPlayerGames + 1);
                winnerPlayer.setPlayerPoints("0");
                loosingPlayer.setPlayerPoints("0");
                break;
            case(""):
                winnerPlayer.setPlayerPoints("40");
                loosingPlayer.setPlayerPoints("40");
                break;
        }
    }
}
