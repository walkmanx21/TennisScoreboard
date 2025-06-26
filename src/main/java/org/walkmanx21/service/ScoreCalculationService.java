package org.walkmanx21.service;

import org.walkmanx21.MatchStatus;
import org.walkmanx21.model.Match;
import org.walkmanx21.model.Player;

public final class ScoreCalculationService {

    private ScoreCalculationService() {}

    public static void scoreCalculation(Integer playerWinPointId, Match match) {
        Player firstPlayer = match.getFirstPlayer();
        Player secondPlayer = match.getSecondPlayer();
        Player playerWinPoint = firstPlayer.getId().equals(playerWinPointId) ? firstPlayer : secondPlayer;

        if (playerWinPoint.equals(firstPlayer)) {
            setsCalculation(firstPlayer, secondPlayer, match);
        } else {
            setsCalculation(secondPlayer, firstPlayer, match);
        }
    }

    private static void setsCalculation(Player winnerPlayer, Player loosingPlayer, Match match) {
        int winnerPlayerSets = winnerPlayer.getPlayerSets();
        int loosingPlayerSets = loosingPlayer.getPlayerSets();

        if (winnerPlayerSets + loosingPlayerSets < 3) {
            gamesCalculation(winnerPlayer, loosingPlayer);
        }
        if (winnerPlayer.getPlayerSets() + loosingPlayer.getPlayerSets() == 3) {
            match.setStatus(MatchStatus.FINISHED);
        }
    }

    private static void gamesCalculation(Player winnerPlayer, Player loosingPlayer) {
        int winnerPlayerGames = winnerPlayer.getPlayerGames();
        int loosingPlayerGames = loosingPlayer.getPlayerGames();

        if (winnerPlayerGames <= 5) {
            pointsCalculation(winnerPlayer, loosingPlayer);
            if (winnerPlayer.getPlayerGames() - loosingPlayerGames >= 2 && winnerPlayer.getPlayerGames() == 6) {
                setIsWon(winnerPlayer, loosingPlayer);
            }
        }

        if (winnerPlayerGames == 6 && loosingPlayerGames == 5) {
            pointsCalculation(winnerPlayer, loosingPlayer);
            if (winnerPlayer.getPlayerGames() == 7) {
                setIsWon(winnerPlayer, loosingPlayer);
            }
        }

        if (winnerPlayerGames == 6 && loosingPlayerGames == 6) {
            tiebreak(winnerPlayer, loosingPlayer);
        }
    }

    private static void pointsCalculation(Player winnerPlayer, Player loosingPlayer) {
        String winnerPlayerPoints = winnerPlayer.getPlayerPoints();
        String loosingPlayerPoints = loosingPlayer.getPlayerPoints();

        switch (winnerPlayerPoints) {
            case ("0"):
                winnerPlayer.setPlayerPoints("15");
                break;
            case ("15"):
                winnerPlayer.setPlayerPoints("30");
                break;
            case ("30"):
                winnerPlayer.setPlayerPoints("40");
                break;
            case ("40"):
                if (!loosingPlayerPoints.equals("40")) {
                    gameIsWon(winnerPlayer, loosingPlayer);
                } else {
                    winnerPlayer.setPlayerPoints("AD");
                    loosingPlayer.setPlayerPoints("");
                }
                break;
            case ("AD"):
                gameIsWon(winnerPlayer, loosingPlayer);
                break;
            case (""):
                winnerPlayer.setPlayerPoints("40");
                loosingPlayer.setPlayerPoints("40");
                break;
        }
    }

    private static void tiebreak(Player winnerPlayer, Player loosingPlayer) {
        int winnerPlayerPoints = Integer.parseInt(winnerPlayer.getPlayerPoints());
        int loosingPlayerPoints = Integer.parseInt(loosingPlayer.getPlayerPoints());

        if (winnerPlayerPoints <= 6) {
            winnerPlayer.setPlayerPoints(String.valueOf(winnerPlayerPoints + 1));
            if (winnerPlayerPoints == 6 && winnerPlayerPoints - loosingPlayerPoints >= 1) {
                setIsWon(winnerPlayer, loosingPlayer);
            }
        }

        if (winnerPlayerPoints > 6) {
            winnerPlayer.setPlayerPoints(String.valueOf(winnerPlayerPoints + 1));
            if (winnerPlayerPoints - loosingPlayerPoints >= 1) {
                setIsWon(winnerPlayer, loosingPlayer);
            }
        }
    }

    private static void setIsWon(Player winnerPlayer, Player loosingPlayer) {
        clearPoints(winnerPlayer, loosingPlayer);
        clearGames(winnerPlayer, loosingPlayer);
        winnerPlayer.setPlayerSets(winnerPlayer.getPlayerSets() + 1);
    }

    private static void gameIsWon(Player winnerPlayer, Player loosingPlayer) {
        clearPoints(winnerPlayer, loosingPlayer);
        winnerPlayer.setPlayerGames(winnerPlayer.getPlayerGames() + 1);
    }

    private static void clearPoints(Player winnerPlayer, Player loosingPlayer) {
        winnerPlayer.setPlayerPoints("0");
        loosingPlayer.setPlayerPoints("0");
    }

    private static void clearGames(Player winnerPlayer, Player loosingPlayer) {
        winnerPlayer.setPlayerGames(0);
        loosingPlayer.setPlayerGames(0);
    }
}
