package org.walkmanx21.service;

import org.walkmanx21.model.Match;
import java.util.concurrent.ConcurrentHashMap;

public class MatchRepositoryService {
    private static final MatchRepositoryService INSTANCE = new MatchRepositoryService();
    private static final ConcurrentHashMap<String, Match> CURRENT_MATCHES = new ConcurrentHashMap<>();

    public static MatchRepositoryService getInstance() {
        return INSTANCE;
    }

    public void addMatch(String matchId, Match match) {
        CURRENT_MATCHES.put(matchId, match);
    }

    public Match getMatch(String matchId) {
        return CURRENT_MATCHES.get(matchId);
    }

    public void removeMatch(String matchId) {
        CURRENT_MATCHES.remove(matchId);
    }

    private MatchRepositoryService(){}
}
