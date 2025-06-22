package service;

import dao.PlayerDao;
import dto.PlayerRequestDto;
import jakarta.persistence.criteria.CriteriaBuilder;
import model.Player;

import java.util.ArrayList;
import java.util.List;

public class PlayerService {
    private static final PlayerService INSTANCE = new PlayerService();
    private static final PlayerDao playerDao = PlayerDao.getInstance();

    public static PlayerService getInstance() {
        return INSTANCE;
    }

    private PlayerService() {}

    public void insertPlayers (List<PlayerRequestDto> playersRequestDto) {
        Player firstPlayer = new Player(playersRequestDto.get(0).getName());
        Player secondPlayer = new Player(playersRequestDto.get(1).getName());
        List<Player> players = new ArrayList<>(List.of(firstPlayer, secondPlayer));
        playerDao.insertPlayers(players);
    }

}
