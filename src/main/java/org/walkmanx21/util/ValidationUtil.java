package org.walkmanx21.util;

import org.walkmanx21.exceptions.SameNamesException;

public final class ValidationUtil {
    private ValidationUtil() {}

    public static void validatePlayersName(String firstPlayerName, String secondPlayerName) {

        if (firstPlayerName.equals(secondPlayerName)) {
            throw new SameNamesException("Имена игроков совпадают");
        }
    }
}
