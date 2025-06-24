package matchScore;

import model.Match;

import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class MatchScoresStorage {
    private static final MatchScoresStorage INSTANCE = new MatchScoresStorage();
    private static ConcurrentHashMap<String, Match> matchScores = new ConcurrentHashMap<>();

    public static MatchScoresStorage getInstance() {
        return INSTANCE;
    }

    public ConcurrentHashMap<String, Match> getMatchScores() {
        return matchScores;
    }

    private MatchScoresStorage(){}
}
