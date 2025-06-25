package org.walkmanx21.service;

import org.walkmanx21.MatchScoresStorage;
import org.walkmanx21.model.Match;
import org.walkmanx21.util.ScoreCalculationUtil;

public class MatchService {
    private static final MatchService INSTANCE = new MatchService();

    private MatchService(){}

    public static MatchService getInstance() {
        return INSTANCE;
    }

    public Match matchPerformance(Integer playerWinPointId, String matchId) {
        Match match = MatchScoresStorage.getInstance().getMatchScores().get(matchId);
        ScoreCalculationUtil.scoreCalculation(playerWinPointId, match);
        return match;
    }
}
