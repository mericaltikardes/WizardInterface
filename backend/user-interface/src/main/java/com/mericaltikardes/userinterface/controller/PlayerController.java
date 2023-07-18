package com.mericaltikardes.userinterface.controller;

import com.mericaltikardes.userinterface.model.Game;
import com.mericaltikardes.userinterface.model.Player;
import com.mericaltikardes.userinterface.service.PlayerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/players")
@CrossOrigin("http://localhost:4173/")
public class PlayerController {
    PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    /*
  "name": "mustafa",
  "surname": "Doe",
  "gender": "MALE",
  "birthDate": "1990-05-15",
  "birthCity": "New York",
  "isActive": true,
  "game": {
    "id": 2
  }
     */
    @PostMapping("/{gameId}")
    public ResponseEntity<Object> addPlayer(@RequestBody Player player, @PathVariable Long gameId) {
        Game game = new Game(gameId);
        player.setGame(game);
        Player savedPlayer = playerService.addPlayer(player);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{gameId}")
                .buildAndExpand(savedPlayer.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }


    @GetMapping("/{gameId}")
    public List<Player> getAllPlayers(@PathVariable Long gameId) {
        return playerService.retrieveAllPlayers(gameId);
    }

    @GetMapping("/{gameId}/{playerId}")
    public List<Player> getPlayer(@PathVariable Long gameId, @PathVariable Long playerId) {
        return Collections.singletonList(playerService.retrieveOnePlayer(gameId, playerId));
    }

    @DeleteMapping("/{gameId}/{playerId}")
    public ResponseEntity<Object> deletePlayer(@PathVariable Long gameId, @PathVariable Long playerId) {
        playerService.deleteOnePlayer(gameId, playerId);
        return ResponseEntity.ok("Player is deleted");

    }

    @PutMapping("/{gameId}/{playerId}")
    public ResponseEntity<Object> updatePlayer(@PathVariable Long gameId, @PathVariable Long playerId, @RequestBody Player updatedPlayer) {
        Game game=new Game(gameId);
        updatedPlayer.setGame(game);
        playerService.updatePlayer(updatedPlayer);
        return ResponseEntity.ok("Player is updated");
    }

}

