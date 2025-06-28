package org.walkmanx21.util;

import jakarta.servlet.http.HttpServletRequest;
import org.walkmanx21.model.Match;

import java.util.List;

public final class SetAttributesUtil {
    private SetAttributesUtil() {
    }

    public static void setMatchesAttributes(HttpServletRequest req, List<Match> matches) {
        req.setAttribute("matches", matches);
    }

    public static int setPageAttributes(HttpServletRequest req, String playerName, int pageNumber, boolean finalPage) {
        if (playerName != null) {
            req.setAttribute("filter_by_player_name", playerName);
        }
        if (pageNumber == 0) {
            req.setAttribute("prev", pageNumber);
            req.setAttribute("page", pageNumber);
            req.setAttribute("next", pageNumber);
        }

        if (pageNumber >= 1) {
            if (pageNumber == 1) {
                req.setAttribute("prev", pageNumber);
            } else {
                req.setAttribute("prev", pageNumber - 1);
            }
            req.setAttribute("page", pageNumber);
            req.setAttribute("next", pageNumber + 1);
        }

        if (finalPage && pageNumber >= 1) {
            if (pageNumber == 1) {
                req.setAttribute("prev", pageNumber);
            } else {
                req.setAttribute("prev", pageNumber - 1);
            }
            req.setAttribute("page", pageNumber);
            req.setAttribute("next", pageNumber);
        }
        return pageNumber;
    }

    public static void setCurrentMatchAttributes(HttpServletRequest req, Match match) {
        req.setAttribute("url", "/match-score?uuid=" + req.getParameter("uuid"));
        req.setAttribute("firstPlayerName", match.getFirstPlayer().getName());
        req.setAttribute("secondPlayerName", match.getSecondPlayer().getName());
        req.setAttribute("firstPlayerSets", match.getFirstPlayer().getPlayerSets());
        req.setAttribute("secondPlayerSets", match.getSecondPlayer().getPlayerSets());
        req.setAttribute("firstPlayerGames", match.getFirstPlayer().getPlayerGames());
        req.setAttribute("secondPlayerGames", match.getSecondPlayer().getPlayerGames());
        req.setAttribute("firstPlayerPoints", match.getFirstPlayer().getPlayerPoints());
        req.setAttribute("secondPlayerPoints", match.getSecondPlayer().getPlayerPoints());
        req.setAttribute("firstPlayerId", match.getFirstPlayer().getId());
        req.setAttribute("secondPlayerId", match.getSecondPlayer().getId());
    }
}
