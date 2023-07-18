package com.mericaltikardes.userinterface.controller;

import com.mericaltikardes.userinterface.model.Game;
import com.mericaltikardes.userinterface.service.GameService;
import org.springframework.aot.generate.AccessControl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/games")
@CrossOrigin(origins = "http://localhost:4173")
public class GameController {
    GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping
    public ResponseEntity<Object> addGame(@RequestBody Game game) {
        Game savedGame = gameService.addGame(game);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{gameId}")
                .buildAndExpand(savedGame.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }
}
