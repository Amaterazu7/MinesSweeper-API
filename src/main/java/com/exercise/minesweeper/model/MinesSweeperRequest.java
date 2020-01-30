package com.exercise.minesweeper.model;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(description = "MinesSweeperRequest Class to create a new game.")
public class MinesSweeperRequest {
    private String userName;
    private int rows, columns, mines;

    public String getUserName() { return userName; }
    public int getRows() { return rows; }
    public int getColumns() { return columns; }
    public int getMines() { return mines; }
}