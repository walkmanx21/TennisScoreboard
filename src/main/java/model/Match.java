package model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "PLAYER1_ID", referencedColumnName = "ID")
    private Player firstPlayer;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "PLAYER2_ID", referencedColumnName = "ID")
    private Player secondPlayer;

    @ManyToOne
    @JoinColumn(name = "WINNER_ID", referencedColumnName = "ID")
    private Player winner;

    public Match(Player firstPlayer, Player secondPlayer) {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
        firstPlayer.setPlayerPoints("0");
        secondPlayer.setPlayerPoints("0");
    }
}
