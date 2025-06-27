package org.walkmanx21.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.walkmanx21.dao.MatchDao;
import org.walkmanx21.model.Match;
import org.walkmanx21.service.MatchRepositoryService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/matches/*")
public class CompletedMatchesServlet extends HttpServlet {

    private static final MatchDao MATCH_DAO = MatchDao.getInstance();
    private static final MatchRepositoryService MATCH_REPOSITORY_SERVICE = MatchRepositoryService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String playerName = req.getParameter("filter_by_player_name");
        List<Match> matches = new ArrayList<>();
        if (playerName != null) {
            matches = MATCH_DAO.getPlayerMatches(playerName);
        }
        if (playerName == null) {
            matches = MATCH_DAO.getAllMatches();
        }
        List<Match> finalMatches = matches;
        matches.forEach(match -> setRequestAttributes(req, finalMatches));
        RequestDispatcher dispatcher = req.getRequestDispatcher("/completedMatches.jsp");
        dispatcher.forward(req, resp);
    }

    private void setRequestAttributes(HttpServletRequest req, List<Match> matches) {
        req.setAttribute("matches", matches);
//        req.setAttribute("matchId", match.getId());
//        req.setAttribute("firstPlayerName", match.getFirstPlayer().getName());
//        req.setAttribute("secondPlayerName", match.getSecondPlayer().getName());
//        req.setAttribute("winnerPlayerName", match.getWinner().getName());

    }
}
