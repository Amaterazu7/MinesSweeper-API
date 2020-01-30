package com.exercise.minesweeper.model;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@ApiModel(description = "Class Square.")
@Document(collection = "Square")
@Data
@Getter
@Setter
public class Square extends BaseModel {
    private final int row;
    private final int column;
    private int value;
    private boolean isMine;
    private boolean wasOpen;
    private boolean isFlagged;

    public Square(int row, int column, int value, boolean isMine, boolean wasOpen, boolean isFlagged) {
        this.row = row;
        this.column = column;
        this.value = value;
        this.isMine = isMine;
        this.wasOpen = wasOpen;
        this.isFlagged = isFlagged;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isMine() {
        return isMine;
    }

    public void setMine() {
        this.isMine = true;
    }

    public boolean wasOpen() {
        return wasOpen;
    }

    public void setOpen() {
        this.wasOpen = true;
    }

    public boolean isFlagged() {
        return isFlagged;
    }

    public void flagToggle() {
        this.isFlagged = !isFlagged;
    }

    public boolean isMineNeighbor(Square square) { return false; }
}
