package com.exercise.minesweeper.service;

import com.exercise.minesweeper.model.MinesSweeperGame;
import com.exercise.minesweeper.model.MinesSweeperRequest;
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
     * Given a gameId,
     * will retrieve an MineSweeperGame.
     *
     * @param gameId
     * @return MinesSweeperGame
     */
    MinesSweeperGame getGameById(String gameId);
    /**
     * Given a user name,
     * will retrieve an MineSweeperGame.
     *
     * @param userName
     * @return MinesSweeperGame
     */
    MinesSweeperGame getGameByUserName(String userName);
    /**
     * Given a user name, minesSweeperGame
     * will be save the new movement of MineSweeperGame.
     *
     * @param userName, MinesSweeperGame
     * @return MinesSweeperGame
     */
    MinesSweeperGame saveMovement(String userName, MinesSweeperGame minesSweeperGame);
    /**
     * Given a gameId
     * will be pause the MineSweeperGame.
     *
     * @param gameId
     * @return MinesSweeperGame
     */
    MinesSweeperGame pauseGame(String gameId);
    /**
     * Given a user name,
     * will be delete the current MineSweeperGame.
     *
     * @param userName
     * @return void
     */
    void gameOver(String userName);
}
