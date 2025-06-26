package org.walkmanx21.service;

import org.walkmanx21.model.Match;

import java.util.concurrent.ConcurrentHashMap;

public class MatchRepositoryService {
    private static final MatchRepositoryService INSTANCE = new MatchRepositoryService();
    private static final ConcurrentHashMap<String, Match> MATCH_REPOSITORY = new ConcurrentHashMap<>();

    public static MatchRepositoryService getInstance() {
        return INSTANCE;
    }

    public void addMatch(String matchId, Match match) {
        MATCH_REPOSITORY.put(matchId, match);
    }

    public Match getMatch(String matchId) {
        return MATCH_REPOSITORY.get(matchId);
    }

    public void removeMatch(String matchId) {
        MATCH_REPOSITORY.remove(matchId);
    }

    private MatchRepositoryService(){}
}
