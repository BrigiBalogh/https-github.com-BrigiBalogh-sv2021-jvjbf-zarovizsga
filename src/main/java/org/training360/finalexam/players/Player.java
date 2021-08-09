package org.training360.finalexam.players;

import lombok.*;
import org.training360.finalexam.teams.Team;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "players")
public class Player {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;

     @Column(name = "player_name")
     private String name;

     @Column(name = "player_birth_date")
     private LocalDate birthDate;

     @Enumerated(EnumType.STRING)
     private PositionType position;

     @ManyToOne
     @EqualsAndHashCode.Exclude
     @ToString.Exclude
     private Team team;

     public Player(String name) {
          this.name = name;
     }

     public Player(String name, LocalDate birthDate, PositionType position) {
          this.name = name;
          this.birthDate = birthDate;
          this.position = position;
     }



     public Player(String name, LocalDate birthDate, PositionType position, Team team) {
          this.name = name;
          this.birthDate = birthDate;
          this.position = position;
          this.team = team;
     }
}
