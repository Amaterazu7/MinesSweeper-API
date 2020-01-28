package com.exercice.minesweeper.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel(description = "MinesSweeperGame Class.")
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
    }

    /*
        if (totalAmountMines > rows * columns) {
            return "There are to many mines for this board.";
        }
    */
    public MinesSweeperBoard getMinesSweeperBoard() {
        return minesSweeperBoard;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getMoves() {
        return moves;
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
