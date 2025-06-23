package controller;

import dao.PlayerDao;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import matchScore.CurrentMatchScore;
import matchScore.MatchScoresStorage;
import model.Player;

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
        CurrentMatchScore currentMatchScore = MatchScoresStorage.getInstance().getMatchScores().get(matchId);

        setRequestAttributes(req, currentMatchScore);
        getServletContext().getRequestDispatcher("/currentMatchScore.jsp").forward(req, resp);
    }

    private void setRequestAttributes(HttpServletRequest req, CurrentMatchScore currentMatchScore) {
        req.setAttribute("url", "/match-score?uuid=" + req.getParameter("uuid"));
        req.setAttribute("firstPlayerName", currentMatchScore.getFirstPlayer().getName());
        req.setAttribute("secondPlayerName", currentMatchScore.getSecondPlayer().getName());
        req.setAttribute("firstPlayerSets", currentMatchScore.getFirstPlayerSet());
        req.setAttribute("secondPlayerSets", currentMatchScore.getSecondPlayerSet());
        req.setAttribute("firstPlayerGames", currentMatchScore.getFirstPlayerGame());
        req.setAttribute("secondPlayerGames", currentMatchScore.getSecondPlayerGame());
        req.setAttribute("firstPlayerPoints", currentMatchScore.getFirstPlayerPoints());
        req.setAttribute("secondPlayerPoints", currentMatchScore.getSecondPlayerPoints());
        req.setAttribute("firstPlayerId", currentMatchScore.getFirstPlayer().getId());
        req.setAttribute("secondPlayerId", currentMatchScore.getSecondPlayer().getId());
    }
}
