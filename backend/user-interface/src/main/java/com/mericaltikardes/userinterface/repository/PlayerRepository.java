package com.mericaltikardes.userinterface.repository;

import com.mericaltikardes.userinterface.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

    List<Player> findAllByGame_Id(Long gameId);

    Player findByGameIdAndId(Long gameId, Long playerId);

}
