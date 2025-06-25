package org.walkmanx21.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.walkmanx21.MatchStatus;

@Entity
@Table(name = "MATCHES", schema = "PUBLIC")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "PLAYER1_ID", referencedColumnName = "ID")
    private Player firstPlayer;

    @ManyToOne
    @JoinColumn(name = "PLAYER2_ID", referencedColumnName = "ID")
    private Player secondPlayer;

    @ManyToOne
    @JoinColumn(name = "WINNER_ID", referencedColumnName = "ID")
    private Player winner;

    private MatchStatus status;
    private String uuid;

    public Match(Player firstPlayer, Player secondPlayer) {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
        this.status = MatchStatus.BEING_PLAYED;
        firstPlayer.setPlayerPoints("0");
        secondPlayer.setPlayerPoints("0");
    }
}
