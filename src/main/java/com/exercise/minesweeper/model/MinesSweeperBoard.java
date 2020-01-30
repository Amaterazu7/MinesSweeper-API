package com.exercise.minesweeper.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

/* An MinesSweeperGame have only one MinesSweeperBoard and int count of moves
 * user can configure a game for that reason the game can set the value of rows, cols and mines
 *
 */
@ApiModel(description = "Class MinesSweeperBoard.")
@Document
@Getter
@Setter
public class MinesSweeperBoard extends BaseModel {
    private final int columns;
    private final int rows;
    private final int mines;
    private List<Square> squares;

    public MinesSweeperBoard(int columns, int rows) {
        this.columnsQuantity = columns;
        this.rowsQuantity = rows;
        this.squares = launchSquares(columns, rows);
    }

    private static List<Square> launchSquares(int columnsQuantity, int rowsQuantity) {
        List<Square> squares = new ArrayList<>();
        for (int row=0; row<columnsQuantity; row++) {
            for (int column=0; column<rowsQuantity; column++) {
                squares.add(new Square(row, column, 0, false, false, false));
            }
        }
        return squares;
    }

    public Square getSquare(int row, int column) {
        return this.squares.get(row * this.rows + column);
    }

    public List<Square> getSquares() {
        return new ArrayList<>(this.squares);
    }

    public int getColumnsQuantity() {
        return columnsQuantity;
    }

    public int getRowsQuantity() {
        return rowsQuantity;
    }

    /*
    public List<Square> getNeighbors(Square square) {

    }
    */
}
