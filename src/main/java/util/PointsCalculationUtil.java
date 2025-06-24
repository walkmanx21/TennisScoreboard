package util;

import matchScore.CurrentMatchScore;
import model.Player;

public final class PointsCalculationUtil {

    private PointsCalculationUtil(){}

    public static CurrentMatchScore pointsCalculation(Integer playerWinPointId, CurrentMatchScore currentMatchScore) {
        Player firstPlayer = currentMatchScore.getFirstPlayer();
        Player secondPlayer = currentMatchScore.getSecondPlayer();
        Player playerWinPoint;
        playerWinPoint = firstPlayer.getId().equals(playerWinPointId) ? firstPlayer : secondPlayer;

        if (playerWinPoint.equals(firstPlayer)) {
            String testPoint1 = currentMatchScore.getFirstPlayerPoints();
            String testPoint2 = currentMatchScore.getSecondPlayerPoints();
            int testGame1 = currentMatchScore.getFirstPlayerGame();
            int testGame2 = currentMatchScore.getSecondPlayerGame();
            switch (testPoint1) {
                case("0"):
                    currentMatchScore.setFirstPlayerPoints("15");
                    break;
                case("15"):
                    currentMatchScore.setFirstPlayerPoints("30");
                    break;
                case("30"):
                    currentMatchScore.setFirstPlayerPoints("40");
                    break;
                case("40"):
                    if (!testPoint2.equals("40")){
                        if (testGame1 == 5 && testGame2 < testGame1) {
                            currentMatchScore.setFirstPlayerSet(currentMatchScore.getFirstPlayerSet() + 1);
                            currentMatchScore.setFirstPlayerGame(0);
                            currentMatchScore.setSecondPlayerGame(0);
                            currentMatchScore.setFirstPlayerPoints("0");
                            currentMatchScore.setSecondPlayerPoints("0");
                            break;
                        }
                        if (testGame1 == 6 && testGame2 == testGame1) {


                        } else {
                            currentMatchScore.setFirstPlayerGame(currentMatchScore.getFirstPlayerGame() + 1);
                            currentMatchScore.setFirstPlayerPoints("0");
                            currentMatchScore.setSecondPlayerPoints("0");
                            break;
                        }
                    } else {
                        currentMatchScore.setFirstPlayerPoints("AD");
                        currentMatchScore.setSecondPlayerPoints("");
                        break;
                    }
                    break;
                case("AD"):
                    currentMatchScore.setFirstPlayerGame(currentMatchScore.getFirstPlayerGame() + 1);
                    currentMatchScore.setFirstPlayerPoints("0");
                    currentMatchScore.setSecondPlayerPoints("0");
                    break;
                case(""):
                    currentMatchScore.setFirstPlayerPoints("40");
                    currentMatchScore.setSecondPlayerPoints("40");
                    break;
            }
        }

        if (playerWinPoint.equals(secondPlayer)) {
            String testPoint1 = currentMatchScore.getSecondPlayerPoints();
            String testPoint2 = currentMatchScore.getFirstPlayerPoints();
            switch (testPoint1) {
                case("0"):
                    currentMatchScore.setSecondPlayerPoints("15");
                    break;
                case("15"):
                    currentMatchScore.setSecondPlayerPoints("30");
                    break;
                case("30"):
                    currentMatchScore.setSecondPlayerPoints("40");
                    break;
                case("40"):
                    if (!testPoint2.equals("40")){
                        currentMatchScore.setSecondPlayerGame(currentMatchScore.getSecondPlayerGame() + 1);
                        currentMatchScore.setSecondPlayerPoints("0");
                        currentMatchScore.setFirstPlayerPoints("0");
                    } else {
                        currentMatchScore.setSecondPlayerPoints("AD");
                        currentMatchScore.setFirstPlayerPoints("");
                    }
                    break;
                case("AD"):
                    currentMatchScore.setSecondPlayerGame(currentMatchScore.getSecondPlayerGame() + 1);
                    currentMatchScore.setSecondPlayerPoints("0");
                    currentMatchScore.setFirstPlayerPoints("0");
                    break;
                case(""):
                    currentMatchScore.setSecondPlayerPoints("40");
                    currentMatchScore.setFirstPlayerPoints("40");
                    break;
            }
        }


        System.out.println();
        return currentMatchScore;
    }
}
