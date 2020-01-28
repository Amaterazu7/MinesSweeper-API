package com.exercice.minesweeper.model;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(description = "MinesSweeperRequest Class. ")
public class MinesSweeperRequest {
    private String userName;
    private int rows, columns, mines;

    public String getUserName() { return userName; }
    public int getRows() { return rows; }
    public int getColumns() { return columns; }
    public int getMines() { return mines; }
}