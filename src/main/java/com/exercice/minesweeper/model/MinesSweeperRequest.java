package com.exercice.minesweeper.model;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(description = "MinesSweeperRequest Class. ")
public class MinesSweeperRequest {
    private String userName;
    private int rows, cols, mines;

    public String getUserName() { return userName; }
}