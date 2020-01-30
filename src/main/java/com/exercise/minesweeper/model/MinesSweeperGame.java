package com.exercise.minesweeper.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Random;

/*
 * An MinesSweeperGame have only one MinesSweeperBoard and int count of moves.
 * The user can configure the game setting the value of rows, cols and mines
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel(description = "Class MinesSweeperGame.")
@Document(collection = "minesSweeperGame")
@Data
@Getter
@Setter
public class MinesSweeperGame extends BaseModel {
    @Indexed(unique = true)
    private String userName;
    private int moves = 0;
    private boolean isPaused = false;
    private final MinesSweeperBoard minesSweeperBoard;

    @PersistenceConstructor
    public MinesSweeperGame(String userName, MinesSweeperBoard minesSweeperBoard) {
        this.userName = userName;
        this.minesSweeperBoard = minesSweeperBoard;
    }

    /*
     * Sets the total amount of mines given by the user and put it randomly in that square position
     */
    public void setMinesOnBoard() {
        // If already is a mine we not set the square
        Random rand = new Random();
        int index = minesSweeperBoard.getRows() * minesSweeperBoard.getColumns();
        for (int i = 0; i < minesSweeperBoard.getMines();) {
            int randomIndex = rand.nextInt(index);
            if(!minesSweeperBoard.getSquares().get(randomIndex).isMine()) {
                minesSweeperBoard.getSquares().get(randomIndex).setMine();
                i++;
            }
        }
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

    public void increaseMoves() { this.moves++; }

    public boolean isPaused() {
        return isPaused;
    }

    public void pauseGame() {
        this.isPaused = !isPaused;
    }
}
