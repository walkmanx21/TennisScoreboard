package model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

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
    private Player player1;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "PLAYER2_ID", referencedColumnName = "ID")
    private Player player2;

    @ManyToOne
    @JoinColumn(name = "WINNER_ID", referencedColumnName = "ID")
    private Player winner;

    public Match(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }
}
