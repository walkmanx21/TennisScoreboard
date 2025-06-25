package controller;

import dto.PlayerRequestDto;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.PlayerService;
import util.ValidationUtil;
import java.io.IOException;

@WebServlet("/new-match")
public class NewMatchServlet extends HttpServlet {

    private final PlayerService playerService = PlayerService.getInstance();

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
        String currentMatchId = playerService.insertPlayers(firstPlayerRequestDto, secondPlayerRequestDto);
        resp.sendRedirect("/match-score?uuid=" + currentMatchId);

        System.out.println();
    }
}