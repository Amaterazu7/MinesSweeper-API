package com.exercise.minesweeper.service;

import com.exercise.minesweeper.model.MinesSweeperGame;
import com.exercise.minesweeper.model.MinesSweeperPlayRequest;
import com.exercise.minesweeper.model.MinesSweeperRequest;
import com.exercise.minesweeper.model.MoveType;
import org.springframework.stereotype.Service;

@Service
public interface MinesSweeperGameService {
    /**
     * Given a user name, count of rows, count of columns and count mines,
     * will be create a new MineSweeperGame.
     *
     * @param minesSweeperRequest
     * @return MinesSweeperGame
     */
    MinesSweeperGame createMinesSweeperGame(MinesSweeperRequest minesSweeperRequest);
    /**
     * Given a user name, count of rows, count of columns and count mines,
     * will be create a new MineSweeperGame.
     *
     * @param userName
     * @return MinesSweeperGame
     */
    MinesSweeperGame getGameByUserName(String userName);
    /**
     * Given a user name, count of rows, count of columns and count mines,
     * will be create a new MineSweeperGame.
     *
     * @param userName, playRequest, move
     * @return MinesSweeperPlayRequest
     */
    MinesSweeperPlayRequest playMinesSweeper(String userName, MinesSweeperPlayRequest playRequest);
    /**
     * Given a user name, count of rows, count of columns and count mines,
     * will be create a new MineSweeperGame.
     *
     * @param userName, playRequest, move
     * @return MinesSweeperPlayRequest
     */
    MinesSweeperPlayRequest setMovement(String userName, MinesSweeperPlayRequest playRequest, MoveType move);
}
