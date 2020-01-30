package com.exercise.minesweeper.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.stream.Collectors;

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
        Collections.shuffle(minesSweeperBoard.getSquares());

        Random rand = new Random();
        for (int i = 0; i < minesSweeperBoard.getMines(); i++) {
            int index = minesSweeperBoard.getRows() * minesSweeperBoard.getColumns();
            minesSweeperBoard.getSquares().get(rand.nextInt(index)).setMine();
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
