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

    public CurrentMatchScore(Player firstPlayer, Player secondPlayer) {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
        firstPlayer.setPlayerPoints("0");
        secondPlayer.setPlayerPoints("0");
    }
}
