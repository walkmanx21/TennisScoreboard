package org.walkmanx21.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.walkmanx21.service.MatchRepositoryService;
import org.walkmanx21.service.MatchStatusService;
import org.walkmanx21.model.Match;
import org.walkmanx21.service.MatchService;

import java.io.IOException;

@WebServlet("/match-score/*")
public class CurrentMatchServlet extends HttpServlet {

    private final MatchService matchService = MatchService.getInstance();
    private static final MatchRepositoryService MATCH_REPOSITORY_SERVICE = MatchRepositoryService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String matchId = req.getParameter("uuid");
        Match match = MATCH_REPOSITORY_SERVICE.getMatch(matchId);

        setRequestAttributes(req, match);
        getServletContext().getRequestDispatcher("/currentMatchScore.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String matchId = req.getParameter("uuid");
        Integer playerWinPointId = Integer.parseInt(req.getParameter("PlayerWin"));
        Match match = matchService.matchPerformance(playerWinPointId, matchId);

        if (match.getStatus() == MatchStatusService.BEING_PLAYED) {
            setRequestAttributes(req, match);
            getServletContext().getRequestDispatcher("/currentMatchScore.jsp").forward(req, resp);
        }

        if (match.getStatus() == MatchStatusService.FINISHED) {
            setRequestAttributes(req, match);
            getServletContext().getRequestDispatcher("/finalScore.jsp").forward(req, resp);
        }
    }

    private void setRequestAttributes(HttpServletRequest req, Match match) {
        req.setAttribute("url", "/match-score?uuid=" + req.getParameter("uuid"));
        req.setAttribute("firstPlayerName", match.getFirstPlayer().getName());
        req.setAttribute("secondPlayerName", match.getSecondPlayer().getName());
        req.setAttribute("firstPlayerSets", match.getFirstPlayer().getPlayerSets());
        req.setAttribute("secondPlayerSets", match.getSecondPlayer().getPlayerSets());
        req.setAttribute("firstPlayerGames", match.getFirstPlayer().getPlayerGames());
        req.setAttribute("secondPlayerGames", match.getSecondPlayer().getPlayerGames());
        req.setAttribute("firstPlayerPoints", match.getFirstPlayer().getPlayerPoints());
        req.setAttribute("secondPlayerPoints", match.getSecondPlayer().getPlayerPoints());
        req.setAttribute("firstPlayerId", match.getFirstPlayer().getId());
        req.setAttribute("secondPlayerId", match.getSecondPlayer().getId());
    }
}
