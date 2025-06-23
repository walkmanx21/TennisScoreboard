package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CurrentMatchScore {
    private Player firstPlayer;
    private Player secondPlayer;

    private int firstPlayerSet;
    private int secondPlayerSet;

    private int firstPlayerGame;
    private int secondPlayerGame;

    private int firstPlayerPoints;
    private int secondPlayerPoints;

    public CurrentMatchScore(Player firstPlayer, Player secondPlayer) {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
    }
}
