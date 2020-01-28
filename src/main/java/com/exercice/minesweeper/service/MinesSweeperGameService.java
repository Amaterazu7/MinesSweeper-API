package com.exercice.minesweeper.service;

import com.exercice.minesweeper.model.MinesSweeperGame;
import com.exercice.minesweeper.model.MinesSweeperPlayRequest;
import com.exercice.minesweeper.model.MinesSweeperRequest;
import com.exercice.minesweeper.model.MoveType;
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
