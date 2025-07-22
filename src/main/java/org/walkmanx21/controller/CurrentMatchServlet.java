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
import org.walkmanx21.util.SetAttributesUtil;

import java.io.IOException;

@WebServlet("/match-score/*")
public class CurrentMatchServlet extends HttpServlet {

    private static final MatchService MATCH_SERVICE = MatchService.getInstance();
    private static final MatchRepositoryService MATCH_REPOSITORY_SERVICE = MatchRepositoryService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String matchId = req.getParameter("uuid");
        Match match = MATCH_REPOSITORY_SERVICE.getMatch(matchId);
        SetAttributesUtil.setCurrentMatchAttributes(req, match);
        getServletContext().getRequestDispatcher("/currentMatchScore.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String matchId = req.getParameter("uuid");
        Integer playerWinPointId = Integer.parseInt(req.getParameter("PlayerWin"));
        Match match = MATCH_SERVICE.matchPerformance(playerWinPointId, matchId);
        SetAttributesUtil.setCurrentMatchAttributes(req, match);

        if (match.getStatus() == MatchStatusService.BEING_PLAYED) {
            getServletContext().getRequestDispatcher("/currentMatchScore.jsp").forward(req, resp);
        }

        if (match.getStatus() == MatchStatusService.FINISHED) {
            getServletContext().getRequestDispatcher("/finalScore.jsp").forward(req, resp);
        }
    }
}
