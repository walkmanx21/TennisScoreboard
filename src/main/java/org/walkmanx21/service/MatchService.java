package org.walkmanx21.service;

import org.walkmanx21.MatchScoresStorage;
import org.walkmanx21.MatchStatus;
import org.walkmanx21.dao.MatchDao;
import org.walkmanx21.model.Match;
import org.walkmanx21.util.ScoreCalculationUtil;

public class MatchService {
    private static final MatchService INSTANCE = new MatchService();
    private static final MatchDao matchDao = MatchDao.getInstance();

    private MatchService(){}

    public static MatchService getInstance() {
        return INSTANCE;
    }

    public Match matchPerformance(Integer playerWinPointId, String matchId) {
        Match match = MatchScoresStorage.getInstance().getMatchScores().get(matchId);
        ScoreCalculationUtil.scoreCalculation(playerWinPointId, match);
        if (match.getFirstPlayer().getPlayerSets() + match.getSecondPlayer().getPlayerSets() == 3) {
            finalizingMatch(match);
        }
        return match;
    }

    private void finalizingMatch(Match match) {
        match.setStatus(MatchStatus.FINISHED);
        if (match.getFirstPlayer().getPlayerSets() > match.getSecondPlayer().getPlayerSets()) {
            match.setWinner(match.getFirstPlayer());
        } else {
            match.setWinner(match.getSecondPlayer());
        }
        matchDao.insertMatch(match);
        MatchScoresStorage.getInstance().getMatchScores().remove(match.getUuid());
    }
}
