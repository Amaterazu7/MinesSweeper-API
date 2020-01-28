package com.exercice.minesweeper.service.impl;

import com.exercice.minesweeper.exception.MinesSweeperException;
import com.exercice.minesweeper.model.MinesSweeperGame;
import com.exercice.minesweeper.model.MinesSweeperPlayRequest;
import com.exercice.minesweeper.model.MinesSweeperRequest;
import com.exercice.minesweeper.model.MoveType;
import com.exercice.minesweeper.repository.MinesSweeperGameRepository;
import com.exercice.minesweeper.service.MinesSweeperGameService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Slf4j
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
            return persistMinesSweeperGame(
                    new MinesSweeperGame(
                            minesSweeperRequest.getRows(),
                            minesSweeperRequest.getColumns(),
                            minesSweeperRequest.getMines(),
                            minesSweeperRequest.getUserName()
                    )
            );

        } catch(Exception ex) {
            throw new MinesSweeperException(String.format("ERROR :: Error creating a new game for userName = ", minesSweeperRequest.getUserName()), ex);
        }
    }

    private MinesSweeperGame persistMinesSweeperGame(MinesSweeperGame minesSweeperGame) {
        return minesSweeperGameRepository.save(minesSweeperGame);
    }

    @Override
    public MinesSweeperGame getGameByUserName(String userName) {
        validateUserName(userName);
        return minesSweeperGameRepository.findById(userName)
                .orElseThrow(() -> new MinesSweeperException(
                        String.format(":: Service ERROR :: There's no current game for this userName::", userName)
                ));
    }

    private void validateUserName(final String userName){
        if(Objects.isNull(userName)){
            throw new MinesSweeperException("UserName can not be NULL");
        }
    }

    @Override
    public MinesSweeperPlayRequest playMinesSweeper(String userName, MinesSweeperPlayRequest playRequest) {
        validateUserName(userName);
        return null;
    }

    @Override
    public MinesSweeperPlayRequest setMovement(String userName, MinesSweeperPlayRequest playRequest, MoveType move) {
        validateUserName(userName);
        return null;
    }

}
