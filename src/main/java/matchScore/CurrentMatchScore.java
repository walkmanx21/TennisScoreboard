package matchScore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import model.Player;

@NoArgsConstructor
@Getter
@Setter
public class CurrentMatchScore {

    private Player firstPlayer;
    private Player secondPlayer;

//    private int firstPlayerSet;
//    private int secondPlayerSet;
//
//    private int firstPlayerGame;
//    private int secondPlayerGame;
//
//    private String firstPlayerPoints;
//    private String secondPlayerPoints;

    public CurrentMatchScore(Player firstPlayer, Player secondPlayer) {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
        firstPlayer.setPlayerPoints("0");
        secondPlayer.setPlayerPoints("0");
    }
}
