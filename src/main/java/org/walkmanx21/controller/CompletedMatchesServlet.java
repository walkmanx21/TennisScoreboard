package org.walkmanx21.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.walkmanx21.dao.MatchDao;
import org.walkmanx21.model.Match;
import org.walkmanx21.util.SetAttributesUtil;

import java.io.IOException;
import java.util.List;

@WebServlet("/matches/*")
public class CompletedMatchesServlet extends HttpServlet {
    private static final MatchDao MATCH_DAO = MatchDao.getInstance();
    private static final int COUNT_OF_ROWS = 10;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String playerName = req.getParameter("filter_by_player_name");
        int pageNumber = getPageNumber(req);

        List<Match> matches = MATCH_DAO.getMatches(playerName, pageNumber, COUNT_OF_ROWS);
        int allMatchesCount = (int)(MATCH_DAO.getAllMatchesCount());
        double finalPageNumber =  (double) allMatchesCount / (double)COUNT_OF_ROWS;

        SetAttributesUtil.setPageAttributes (req, playerName, pageNumber, finalPageNumber);
        matches.forEach(match -> SetAttributesUtil.setMatchesAttributes(req, matches));

        RequestDispatcher dispatcher = req.getRequestDispatcher("/completedMatches.jsp");
        dispatcher.forward(req, resp);
    }

    private int getPageNumber(HttpServletRequest req) {
        String page = req.getParameter("page");
        int pageNumber;
        if (page == null) {
            pageNumber = 1;
        } else {
            pageNumber = Integer.parseInt(page);
        }
        return pageNumber;
    }
}
