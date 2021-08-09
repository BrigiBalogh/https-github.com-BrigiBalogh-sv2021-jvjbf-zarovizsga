package org.training360.finalexam.players;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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

     @Column(name = "player_birthDate")
     private LocalDate birthDate;

     @Enumerated(EnumType.STRING)
     private PositionType position;

     @ManyToOne
     private Team team;



}
