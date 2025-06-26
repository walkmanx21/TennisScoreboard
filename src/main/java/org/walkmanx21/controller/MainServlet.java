package org.walkmanx21.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.walkmanx21.dao.MatchDao;
import org.walkmanx21.dao.PlayerDao;
import org.walkmanx21.model.Match;
import org.walkmanx21.model.Player;
import org.walkmanx21.service.MatchService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/")
public class MainServlet extends HttpServlet {
    private static final MatchDao MATCH_DAO = MatchDao.getInstance();
    private static final PlayerDao PLAYER_DAO = PlayerDao.getInstance();
    private int count = 0;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
        dispatcher.forward(req, resp);
        setStartingData();
    }

    private void setStartingData() {
        if (count == 0) {
            List<Player> players = new ArrayList<>();
            players.add(new Player("Sergey"));
            players.add(new Player("Ilmira"));
            players.add(new Player("Dmitry"));
            players.add(new Player("Alice"));
            players.add(new Player("Milana"));
            players.add(new Player("Ivan"));
            players.add(new Player("Maxim"));
            players.add(new Player("Denis"));
            players.add(new Player("Alexey"));
            players.add(new Player("Anton"));
            players.add(new Player("Andrey"));
            players.add(new Player("Victor"));
            players.forEach(PLAYER_DAO::insertPlayer);

            for (int i = 0, j = players.size() - 1; i < players.size(); i++, j--) {
                MATCH_DAO.insertMatch(new Match(players.get(i), players.get(j), players.get(i)));
            }

            count++;
        }
    }
}
