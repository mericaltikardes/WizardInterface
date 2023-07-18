package com.mericaltikardes.userinterface.service;

import com.mericaltikardes.userinterface.model.Player;
import com.mericaltikardes.userinterface.repository.PlayerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public Player addPlayer(Player player) {
        return playerRepository.save(player);
    }

    public List<Player> retrieveAllPlayers(Long gameId) {
        return playerRepository.findAllByGame_Id(gameId);
    }

    public Player retrieveOnePlayer(Long gameId, Long playerId) {
        Player player = playerRepository.findByGameIdAndId(gameId, playerId);
        if (player == null) {
            throw new EntityNotFoundException("Player not found with gameId: " + gameId + " and playerId: " + playerId);
        }
        return player;
    }

    public void deleteOnePlayer(Long gameId, Long playerId) {
        Player player = retrieveOnePlayer(gameId, playerId);
        if (player != null) {
            playerRepository.delete(player);
        } else {
            throw new EntityNotFoundException("Player not found with gameId: " + gameId + " and playerId: " + playerId);
        }
    }

    public void updatePlayer(Player updatedPlayer) {
        Long gameId = updatedPlayer.getGame().getId();
        Long playerId = updatedPlayer.getId();

        Player player = playerRepository.findByGameIdAndId(gameId, playerId);
        if (player == null) {
            throw new EntityNotFoundException("Player not found with gameId: " + gameId + " and playerId: " + playerId);
        }

        player.setName(updatedPlayer.getName());
        player.setSurname(updatedPlayer.getSurname());
        player.setGender(updatedPlayer.getGender());
        player.setBirthDate(updatedPlayer.getBirthDate());
        player.setBirthCity(updatedPlayer.getBirthCity());
        player.setActive(updatedPlayer.isActive());
        player.setGame(updatedPlayer.getGame());

        playerRepository.save(player);
    }


}
