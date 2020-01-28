package com.exercice.minesweeper.service.impl;

import com.exercice.minesweeper.exception.MinesSweeperException;
import com.exercice.minesweeper.model.MinesSweeperGame;
import com.exercice.minesweeper.model.MinesSweeperRequest;
import com.exercice.minesweeper.repository.MinesSweeperGameRepository;
import com.exercice.minesweeper.service.MinesSweeperGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MinesSweeperGameServiceImpl implements MinesSweeperGameService {
    private final MinesSweeperGameRepository minesSweeperGameRepository;

    @Autowired
    MinesSweeperGameServiceImpl(MinesSweeperGameRepository minesSweeperGameRepository) {
        this.minesSweeperGameRepository = minesSweeperGameRepository;
    }

    @Override
    public MinesSweeperGame createMinesSweeperGame(MinesSweeperRequest minesSweeperRequest) {
        try {

            return null;
        } catch(Exception ex) {
            throw new MinesSweeperException(String.format("ERROR :: Error creating a new game for username = ", minesSweeperRequest.getUserName()), ex);
        }
    }

    @Override
    public MinesSweeperGame getGameByUserName(String userName) {
        return null;
    }
}
