package org.walkmanx21.service;

import org.walkmanx21.dao.PlayerDao;
import org.walkmanx21.dto.PlayerRequestDto;
import org.walkmanx21.model.Match;
import org.walkmanx21.model.Player;

import java.util.UUID;

public class PlayerService {
    private static final PlayerService INSTANCE = new PlayerService();
    private static final PlayerDao PLAYER_DAO = PlayerDao.getInstance();
    private static final MatchRepositoryService MATCH_REPOSITORY_SERVICE = MatchRepositoryService.getInstance();

    public static PlayerService getInstance() {
        return INSTANCE;
    }

    private PlayerService() {}

    public Player insertPlayer(PlayerRequestDto playerRequestDto) {
        Player player = new Player(playerRequestDto.getName());
        PLAYER_DAO.insertPlayer(player);
        return player;
    }
}
