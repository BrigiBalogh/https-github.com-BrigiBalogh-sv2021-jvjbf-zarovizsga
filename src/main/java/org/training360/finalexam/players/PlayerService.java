package org.training360.finalexam.players;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PlayerService {


    private ModelMapper mapper;

    private PlayerRepository playerRepository;


    public List<PlayerDTO> listPlayers() {
        Type targetListType = new TypeToken<List<PlayerDTO>>() {
        }.getType();
        return mapper.map(playerRepository.findAll(), targetListType);
    }

    public PlayerDTO createPlayer(CreatePlayerCommand command) {
        Player player = playerRepository.save(
                new Player(command.getName(), command.getBirthDate(), command.getPosition()));
        return mapper.map(player, PlayerDTO.class);
    }

    public void deleteById(Long id) {
        playerRepository.deleteById(id);
    }



}
