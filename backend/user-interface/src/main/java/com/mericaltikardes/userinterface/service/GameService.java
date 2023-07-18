package com.mericaltikardes.userinterface.service;

import com.mericaltikardes.userinterface.model.Game;
import com.mericaltikardes.userinterface.repository.GameRepository;
import org.springframework.stereotype.Service;

@Service
public class GameService {
    GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public Game addGame(Game game) {
        return gameRepository.save(game);
    }
}
