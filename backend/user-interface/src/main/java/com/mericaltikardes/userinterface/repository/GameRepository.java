package com.mericaltikardes.userinterface.repository;

import com.mericaltikardes.userinterface.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<Game,Long> {
}
