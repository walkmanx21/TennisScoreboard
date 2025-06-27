package org.walkmanx21.service;

import org.walkmanx21.dao.MatchDao;
import org.walkmanx21.model.Match;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

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
