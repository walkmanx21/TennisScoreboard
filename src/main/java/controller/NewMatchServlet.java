package controller;

import dto.PlayerRequestDto;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Match;
import service.PlayerService;
import util.ValidationUtil;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.List;

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

        List<PlayerRequestDto> playersDto = List.of(firstPlayerRequestDto, secondPlayerRequestDto);
        playerService.insertPlayers(playersDto);

        System.out.println();
    }
}