package org.walkmanx21.controller;

import org.walkmanx21.dto.PlayerRequestDto;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.walkmanx21.model.Match;
import org.walkmanx21.model.Player;
import org.walkmanx21.service.MatchService;
import org.walkmanx21.service.PlayerService;
import org.walkmanx21.util.ValidationUtil;
import java.io.IOException;

@WebServlet("/new-match")
public class NewMatchServlet extends HttpServlet {

    private static final PlayerService PLAYER_SERVICE = PlayerService.getInstance();
    private static final MatchService MATCH_SERVICE = MatchService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/newMatch.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstPlayerName = req.getParameter("firstPlayerName");
        String secondPlayerName = req.getParameter("secondPlayerName");

        ValidationUtil.validatePlayersName(firstPlayerName, secondPlayerName);

        PlayerRequestDto firstPlayerRequestDto = new PlayerRequestDto(firstPlayerName);
        PlayerRequestDto secondPlayerRequestDto = new PlayerRequestDto(secondPlayerName);

        Player firstPlayer = PLAYER_SERVICE.insertPlayer(firstPlayerRequestDto);
        Player secondPlayer = PLAYER_SERVICE.insertPlayer(secondPlayerRequestDto);

        Match match = MATCH_SERVICE.createNewMatch(firstPlayer, secondPlayer);
        resp.sendRedirect("/match-score?uuid=" + match.getUuid());
    }
}