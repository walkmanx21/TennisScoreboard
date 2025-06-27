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
import java.util.List;

@WebServlet("/matches/*")
public class CompletedMatchesServlet extends HttpServlet {

    private static final MatchDao MATCH_DAO = MatchDao.getInstance();
    private static final MatchRepositoryService MATCH_REPOSITORY_SERVICE = MatchRepositoryService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        List<Match> allMatches = MATCH_REPOSITORY_SERVICE.getCompletedMatches();
        List<Match> allMatches = MATCH_DAO.getAllMatches();
        allMatches.forEach(match -> setRequestAttributes(req, allMatches));
        RequestDispatcher dispatcher = req.getRequestDispatcher("/completedMatches.jsp");
        dispatcher.forward(req, resp);
    }

    private void setRequestAttributes(HttpServletRequest req, List<Match> matches) {
        req.setAttribute("allMatches", matches);
//        req.setAttribute("matchId", match.getId());
//        req.setAttribute("firstPlayerName", match.getFirstPlayer().getName());
//        req.setAttribute("secondPlayerName", match.getSecondPlayer().getName());
//        req.setAttribute("winnerPlayerName", match.getWinner().getName());

    }
}
