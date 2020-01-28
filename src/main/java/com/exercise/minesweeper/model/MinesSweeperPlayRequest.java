package com.exercise.minesweeper.model;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(description = "MinesSweeperPlayRequest Class. ")
public class MinesSweeperPlayRequest {
    private int row, column;

    public int getRow() { return row; }

    public int getColumn() { return column; }
}