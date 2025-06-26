package org.walkmanx21.service;

import org.walkmanx21.MatchStatus;
import org.walkmanx21.dao.MatchDao;
import org.walkmanx21.model.Match;

public class MatchService {
    private static final MatchService INSTANCE = new MatchService();
    private static final MatchDao MATCH_DAO = MatchDao.getInstance();
    private static final MatchRepositoryService MATCH_REPOSITORY_SERVICE = MatchRepositoryService.getInstance();

    private MatchService(){}

    public static MatchService getInstance() {
        return INSTANCE;
    }

    public Match matchPerformance(Integer playerWinPointId, String matchId) {
        Match match = MATCH_REPOSITORY_SERVICE.getMatch(matchId);
        MatchStatus matchStatus = match.getStatus();
        if (matchStatus == MatchStatus.BEING_PLAYED) {
            ScoreCalculationService.scoreCalculation(playerWinPointId, match);
        } else {
            finalizingMatch(match);
        }

//        if (match.getFirstPlayer().getPlayerSets() + match.getSecondPlayer().getPlayerSets() == 3) {
//            finalizingMatch(match);
//        }
        return match;
    }

    private void finalizingMatch(Match match) {
//        match.setStatus(MatchStatus.FINISHED);
        if (match.getFirstPlayer().getPlayerSets() > match.getSecondPlayer().getPlayerSets()) {
            match.setWinner(match.getFirstPlayer());
        } else {
            match.setWinner(match.getSecondPlayer());
        }
        MATCH_DAO.insertMatch(match);
        MATCH_REPOSITORY_SERVICE.removeMatch(match.getUuid());
    }
}
