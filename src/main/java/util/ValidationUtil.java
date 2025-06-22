package util;

import dto.PlayerRequestDto;
import exceptions.SameNamesException;

import java.util.List;

public final class ValidationUtil {
    private ValidationUtil() {}

    public static void validatePlayersName(String firstPlayerName, String secondPlayerName) {

        if (firstPlayerName.equals(secondPlayerName)) {
            throw new SameNamesException("The names of the players match");
        }
    }
}
