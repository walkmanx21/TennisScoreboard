package org.walkmanx21.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "PLAYERS", schema = "PUBLIC")
@NoArgsConstructor
@Getter
@Setter
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NAME", nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "firstPlayer")
    private List<Match> playedMatches;

    @OneToMany(mappedBy = "winner")
    private List<Match> wonMatches;

    private int playerSets;
    private int playerGames;

    private String playerPoints;

    public Player(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "model.Player{" +
               "id=" + id +
               ", name='" + name + '\'' +
               '}';
    }
}
