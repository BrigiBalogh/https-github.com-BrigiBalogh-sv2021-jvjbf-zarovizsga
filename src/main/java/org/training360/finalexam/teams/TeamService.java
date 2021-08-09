package org.training360.finalexam.teams;


import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.training360.finalexam.players.CreatePlayerCommand;
import org.training360.finalexam.players.Player;
import org.training360.finalexam.players.PlayerRepository;
import org.training360.finalexam.players.UpdateWithExistingPlayerCommand;

import java.lang.reflect.Type;
import java.util.List;

@Service
@AllArgsConstructor
public class TeamService {




    private final TeamRepository teamRepository;
    private final PlayerRepository playerRepository;
    private final ModelMapper mapper;

    public TeamDTO createTeam(CreateTeamCommand command) {
        Team team = teamRepository.save(new Team(command.getName()));
        return mapper.map(team, TeamDTO.class);
    }

    public List<TeamDTO> listTeams() {
        Type targetListType = new TypeToken<List<TeamDTO>>() {
        }.getType();
        return mapper.map(teamRepository.findAll(), targetListType);
    }


    @Transactional
    public TeamDTO addNewPlayerToTeam(Long id, CreatePlayerCommand command) {
        Team team = findById(id);
        Player player = playerRepository.save(new Player(command.getName(), command.getBirthDate(), command.getPosition()));
        team.addNewPlayer(player);
        return mapper.map(team, TeamDTO.class);
    }




}
