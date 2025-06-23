package service;

import dao.PlayerDao;
import dto.PlayerRequestDto;
import matchScore.CurrentMatchScore;
import matchScore.MatchScoresStorage;
import model.Player;

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
        CurrentMatchScore currentMatchScore = new CurrentMatchScore(firstPlayer, secondPlayer);
        String currentMatchId = UUID.randomUUID().toString();
        MatchScoresStorage.getInstance().getMatchScores().put(currentMatchId, currentMatchScore);
        return currentMatchId;
    }

}
