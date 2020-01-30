package com.exercise.minesweeper.service.impl;

import com.exercise.minesweeper.exception.MinesSweeperException;
import com.exercise.minesweeper.model.*;
import com.exercise.minesweeper.repository.MinesSweeperBoardRepository;
import com.exercise.minesweeper.repository.MinesSweeperGameRepository;
import com.exercise.minesweeper.service.MinesSweeperGameService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Slf4j
@Service
public class MinesSweeperGameServiceImpl implements MinesSweeperGameService {
    private final MinesSweeperGameRepository minesSweeperGameRepository;
    private final MinesSweeperBoardRepository minesSweeperBoardRepository;

    @Autowired
    MinesSweeperGameServiceImpl(MinesSweeperGameRepository minesSweeperGameRepository,
                                MinesSweeperBoardRepository minesSweeperBoardRepository) {
        this.minesSweeperGameRepository = minesSweeperGameRepository;
        this.minesSweeperBoardRepository = minesSweeperBoardRepository;
    }

    @Override
    public MinesSweeperGame createMinesSweeperGame(MinesSweeperRequest minesSweeperRequest) {
        try {
            MinesSweeperBoard minesSweeperBoard = new MinesSweeperBoard(
                    minesSweeperRequest.getColumns(), minesSweeperRequest.getRows(), minesSweeperRequest.getMines()
            );
            MinesSweeperGame minesSweeperGame = new MinesSweeperGame(
                    minesSweeperRequest.getUserName(), minesSweeperBoard
            );
            minesSweeperGame.setMinesOnBoard();

            return persistMinesSweeperGame(minesSweeperGame, minesSweeperBoard);

        } catch(Exception ex) {
            throw new MinesSweeperException(String.format("ERROR :: Error creating a new game for userName = ", minesSweeperRequest.getUserName()), ex);
        }
    }

    private MinesSweeperGame persistMinesSweeperGame(MinesSweeperGame minesSweeperGame, MinesSweeperBoard minesSweeperBoard) {
        minesSweeperBoardRepository.save(minesSweeperBoard);
        return minesSweeperGameRepository.save(minesSweeperGame);
    }

    @Override
    public MinesSweeperGame getGameById(String id) {
        validateEmpty(id);
        return minesSweeperGameRepository.findById(id)
                .orElseThrow(() -> new MinesSweeperException(
                        String.format(":: Service ERROR :: There's no current game for this Id::", id)
                ));
    }

    @Override
    public MinesSweeperGame getGameByUserName(String userName) {
        validateEmpty(userName);
        return minesSweeperGameRepository.findByUserName(userName);
    }

    @Override
    public MinesSweeperPlayRequest playMinesSweeper(String userName, MinesSweeperPlayRequest playRequest) {
        validateEmpty(userName);
        return null;
    }

    @Override
    public MinesSweeperPlayRequest setMovement(String userName, MinesSweeperPlayRequest playRequest, MoveType move) {
        validateEmpty(userName);
        return null;
    }

    @Override
    public void gameOver(String id) {
        validateEmpty(id);
        minesSweeperGameRepository.deleteById(id);
    }

    private void validateEmpty(final String userName){
        if(Objects.isNull(userName)) {
            throw new MinesSweeperException("UserName can not be NULL");
        }
    }

}
