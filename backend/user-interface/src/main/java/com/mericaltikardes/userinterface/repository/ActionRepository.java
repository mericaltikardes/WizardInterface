package com.mericaltikardes.userinterface.repository;

import com.mericaltikardes.userinterface.model.Action;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActionRepository extends JpaRepository<Action, Long> {
}
