package org.walkmanx21.service;

import org.walkmanx21.dao.PlayerDao;
import org.walkmanx21.dto.PlayerRequestDto;
import org.walkmanx21.MatchScoresStorage;
import org.walkmanx21.model.Match;
import org.walkmanx21.model.Player;

import java.util.UUID;

public class PlayerService {
    private static final PlayerService INSTANCE = new PlayerService();
    private static final PlayerDao playerDao = PlayerDao.getInstance();

    public static PlayerService getInstance() {
        return INSTANCE;
    }

    private PlayerService() {}

    public String insertPlayers (PlayerRequestDto firstPlayerRequestDto, PlayerRequestDto secondPlayerRequestDto) {
        Player firstPlayer = new Player(firstPlayerRequestDto.getName());
        Player secondPlayer = new Player(secondPlayerRequestDto.getName());
        playerDao.insertPlayers(firstPlayer, secondPlayer);
        Match match = new Match(firstPlayer, secondPlayer);
        String currentMatchId = UUID.randomUUID().toString();
        match.setUuid(currentMatchId);
        MatchScoresStorage.getInstance().getMatchScores().put(currentMatchId, match);
        return currentMatchId;
    }
}
