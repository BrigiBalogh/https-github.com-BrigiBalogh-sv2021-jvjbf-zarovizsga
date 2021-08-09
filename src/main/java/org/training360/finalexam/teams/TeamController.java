package org.training360.finalexam.teams;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.training360.finalexam.players.CreatePlayerCommand;
import org.training360.finalexam.players.UpdateWithExistingPlayerCommand;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/teams")
public class TeamController {



    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TeamDTO createTeam(
            @Valid @RequestBody CreateTeamCommand command
    ) {
        return teamService.createTeam(command);
    }

    @GetMapping
    public List<TeamDTO> listTeams() {
        return teamService.listTeams();
    }

    @PostMapping("/{id}/players")
    @ResponseStatus(HttpStatus.CREATED)
    public TeamDTO addNewPlayerToTeam(
            @PathVariable Long id,
            @Valid @RequestBody CreatePlayerCommand command
    ) {
        return teamService.addNewPlayerToTeam(id, command);
    }

    @PutMapping ("/{id}/players")
    TeamDTO addExistingPlayerToTeam(@RequestBody UpdateWithExistingPlayerCommand command, @PathVariable Long id ){
        return teamService.addExistingPlayerToTeam(command, id);
    }

}
