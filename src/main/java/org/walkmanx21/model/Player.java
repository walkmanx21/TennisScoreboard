package org.walkmanx21.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "players", schema = "public")
@NoArgsConstructor
@Getter
@Setter
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

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
