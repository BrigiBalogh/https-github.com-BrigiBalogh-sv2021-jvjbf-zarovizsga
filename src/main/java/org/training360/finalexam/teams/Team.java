package org.training360.finalexam.teams;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.training360.finalexam.players.Player;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "teams")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "team_name")
    private String name;

    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL)
    private List<Player> players ;

    public Team(String name) {
        this.name = name;
    }

    public void addNewPlayer(Player player) {
        player.setTeam(this);
        if (players == null) {
            players = new ArrayList<>();
        }
        players.add(player);
    }


}
