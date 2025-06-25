package matchScore;

import java.util.concurrent.ConcurrentHashMap;

public class MatchScoresStorage {
    private static final MatchScoresStorage INSTANCE = new MatchScoresStorage();
    private static ConcurrentHashMap<String, model.Match> matchScores = new ConcurrentHashMap<>();

    public static MatchScoresStorage getInstance() {
        return INSTANCE;
    }

    public ConcurrentHashMap<String, model.Match> getMatchScores() {
        return matchScores;
    }

    private MatchScoresStorage(){}
}
