package com.mericaltikardes.userinterface.service;

import com.mericaltikardes.userinterface.model.Action;
import com.mericaltikardes.userinterface.repository.ActionRepository;
import org.springframework.stereotype.Service;

@Service
public class ActionService {

    ActionRepository actionRepository;

    public ActionService(ActionRepository actionRepository) {
        this.actionRepository = actionRepository;
    }

    public void addAction(Action action) {
        actionRepository.save(action);
    }

}
