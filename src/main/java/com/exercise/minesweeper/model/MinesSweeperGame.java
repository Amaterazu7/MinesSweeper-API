package com.exercise.minesweeper.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Collections;

/*
 * An MinesSweeperGame have only one MinesSweeperBoard and int count of moves.
 * The user can configure the game setting the value of rows, cols and mines
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel(description = "Class MinesSweeperGame.")
@Document
@Getter
@Setter
public class MinesSweeperGame extends BaseModel {
    private final MinesSweeperBoard minesSweeperBoard;
    private String userName;
    private int moves;
    private boolean isPaused;

    public MinesSweeperGame(int rows, int columns, int totalAmountMines, String userName) {
        this.minesSweeperBoard = new MinesSweeperBoard(rows, columns);
        this.userName = userName;
        this.moves = 0;
        this.isPaused = false;
        setMinesOnBoard(totalAmountMines);
    }

    /*
     * Sets the total amount of mines given by the user and put it randomly in that square position
     */
    private void setMinesOnBoard(int mines) {
        new ArrayList<>(minesSweeperBoard.getSquares())
                .stream()
                .limit(mines)
                .forEach(Square::setMine);
        Collections.shuffle(minesSweeperBoard.getSquares());
    }

    public MinesSweeperBoard getMinesSweeperBoard() {
        return minesSweeperBoard;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getMoves() {
        return this.moves;
    }

    private void increaseMoves() {
        this.moves++;
    }

    public void setMoves(int moves) {
        this.moves = moves;
    }

    public boolean isPaused() {
        return isPaused;
    }

    public void pauseGame() {
        this.isPaused = !isPaused;
    }
}
