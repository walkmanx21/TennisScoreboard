package service;

import dao.PlayerDao;
import dto.PlayerRequestDto;
import model.CurrentMatchScore;
import model.Player;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class PlayerService {
    private static final PlayerService INSTANCE = new PlayerService();
    private static final PlayerDao playerDao = PlayerDao.getInstance();

    public static PlayerService getInstance() {
        return INSTANCE;
    }

    private PlayerService() {}

    public UUID insertPlayers (PlayerRequestDto firstPlayerRequestDto, PlayerRequestDto secondPlayerRequestDto) {
        Player firstPlayer = new Player(firstPlayerRequestDto.getName());
        Player secondPlayer = new Player(secondPlayerRequestDto.getName());
        playerDao.insertPlayers(firstPlayer, secondPlayer);
        CurrentMatchScore currentMatchScore = new CurrentMatchScore(firstPlayer, secondPlayer);
        ConcurrentHashMap<UUID, CurrentMatchScore> matchesScore = new ConcurrentHashMap<>();
        UUID currentMatchUuid = UUID.randomUUID();
        matchesScore.put(currentMatchUuid, currentMatchScore);
        return  currentMatchUuid;
    }

}
