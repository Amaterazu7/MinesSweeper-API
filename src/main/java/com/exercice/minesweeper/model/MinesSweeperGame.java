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

}
