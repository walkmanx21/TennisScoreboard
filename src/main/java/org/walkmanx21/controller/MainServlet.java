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

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@WebServlet("/")
public class MainServlet extends HttpServlet {
    private static final MatchDao MATCH_DAO = MatchDao.getInstance();
    private static final PlayerDao PLAYER_DAO = PlayerDao.getInstance();
    private int count = 0;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/main.jsp");
        dispatcher.forward(req, resp);
        setStartingData();
    }

    private void setStartingData() {
        if (count == 0) {
            List<Player> players = new ArrayList<>();
            players.add(new Player("Сергей"));
            players.add(new Player("Ильмира"));
            players.add(new Player("Дмитрий"));
            players.add(new Player("Алиса"));
            players.add(new Player("Милана"));
            players.add(new Player("Иван"));
            players.add(new Player("Максим"));
            players.add(new Player("Денис"));
            players.add(new Player("Алексей"));
            players.add(new Player("Антон"));
            players.add(new Player("Андрей"));
            players.add(new Player("Валерий"));
            players.add(new Player("Петр"));
            players.add(new Player("Татьяна"));
            players.add(new Player("Александр"));
            players.add(new Player("Виталий"));
            players.add(new Player("Елена"));
            players.add(new Player("Владимир"));
            players.add(new Player("Владислав"));
            players.add(new Player("Ангелина"));
            players.forEach(PLAYER_DAO::insertPlayer);
            createStartingMatches(players);
            Collections.shuffle(players);
            createStartingMatches(players);
            count++;
        }
    }

    private void createStartingMatches(List<Player> players) {
        for (int i = 0, j = players.size() - 1; i < players.size(); i++, j--) {
            MATCH_DAO.insertMatch(new Match(players.get(i), players.get(j), players.get(i)));
        }
    }
}
