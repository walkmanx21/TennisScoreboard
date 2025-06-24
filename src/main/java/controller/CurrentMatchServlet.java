package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import matchScore.CurrentMatchScore;
import matchScore.MatchScoresStorage;
import util.PointsCalculationUtil;

import java.io.IOException;

@WebServlet("/match-score/*")
public class CurrentMatchServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String matchId = req.getParameter("uuid");
        CurrentMatchScore currentMatchScore = MatchScoresStorage.getInstance().getMatchScores().get(matchId);

        setRequestAttributes(req, currentMatchScore);
        getServletContext().getRequestDispatcher("/currentMatchScore.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String matchId = req.getParameter("uuid");
        Integer playerWinPointId = Integer.parseInt(req.getParameter("PlayerWin"));
        CurrentMatchScore currentMatchScore = MatchScoresStorage.getInstance().getMatchScores().get(matchId);
        PointsCalculationUtil.scoreCalculation(playerWinPointId, currentMatchScore);

        setRequestAttributes(req, currentMatchScore);
        getServletContext().getRequestDispatcher("/currentMatchScore.jsp").forward(req, resp);
    }

    private void setRequestAttributes(HttpServletRequest req, CurrentMatchScore currentMatchScore) {
        req.setAttribute("url", "/match-score?uuid=" + req.getParameter("uuid"));
        req.setAttribute("firstPlayerName", currentMatchScore.getFirstPlayer().getName());
        req.setAttribute("secondPlayerName", currentMatchScore.getSecondPlayer().getName());
        req.setAttribute("firstPlayerSets", currentMatchScore.getFirstPlayer().getPlayerSets());
        req.setAttribute("secondPlayerSets", currentMatchScore.getSecondPlayer().getPlayerSets());
        req.setAttribute("firstPlayerGames", currentMatchScore.getFirstPlayer().getPlayerGames());
        req.setAttribute("secondPlayerGames", currentMatchScore.getSecondPlayer().getPlayerGames());
        req.setAttribute("firstPlayerPoints", currentMatchScore.getFirstPlayer().getPlayerPoints());
        req.setAttribute("secondPlayerPoints", currentMatchScore.getSecondPlayer().getPlayerPoints());
        req.setAttribute("firstPlayerId", currentMatchScore.getFirstPlayer().getId());
        req.setAttribute("secondPlayerId", currentMatchScore.getSecondPlayer().getId());
    }
}
