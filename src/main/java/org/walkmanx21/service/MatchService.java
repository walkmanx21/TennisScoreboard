package org.walkmanx21.service;

import org.walkmanx21.dao.MatchDao;
import org.walkmanx21.model.Match;
import org.walkmanx21.model.Player;

import java.util.List;
import java.util.UUID;

public class MatchService {
    private static final MatchService INSTANCE = new MatchService();
    private static final MatchDao MATCH_DAO = MatchDao.getInstance();
    private static final MatchRepositoryService MATCH_REPOSITORY_SERVICE = MatchRepositoryService.getInstance();

    private MatchService(){}

    public static MatchService getInstance() {
        return INSTANCE;
    }

    public Match createNewMatch(Player firstPlayer, Player secondPlayer) {
        Match match = new Match(firstPlayer, secondPlayer);
        String currentMatchId = UUID.randomUUID().toString();
        match.setUuid(currentMatchId);
        MATCH_REPOSITORY_SERVICE.addMatch(currentMatchId, match);
        return match;
    }

    public Match matchPerformance(Integer playerWinPointId, String matchId) {
        Match match = MATCH_REPOSITORY_SERVICE.getMatch(matchId);
        MatchStatusService matchStatus = match.getStatus();
        if (matchStatus == MatchStatusService.BEING_PLAYED) {
            ScoreCalculationService.scoreCalculation(playerWinPointId, match);
            if (match.getStatus() == MatchStatusService.FINISHED) {
                finalizingMatch(match);
            }
        }

        return match;
    }

    private void finalizingMatch(Match match) {
        if (match.getFirstPlayer().getPlayerSets() > match.getSecondPlayer().getPlayerSets()) {
            match.setWinner(match.getFirstPlayer());
        } else {
            match.setWinner(match.getSecondPlayer());
        }
        MATCH_DAO.insertMatch(match);
        MATCH_REPOSITORY_SERVICE.removeMatch(match.getUuid());
    }


}
