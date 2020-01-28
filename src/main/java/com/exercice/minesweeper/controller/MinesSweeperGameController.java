package com.exercice.minesweeper.controller;

import com.exercice.minesweeper.exception.MinesSweeperException;
import com.exercice.minesweeper.model.MinesSweeperGame;
import com.exercice.minesweeper.model.MinesSweeperPlayRequest;
import com.exercice.minesweeper.model.MinesSweeperRequest;
import com.exercice.minesweeper.model.MoveType;
import com.exercice.minesweeper.service.MinesSweeperGameService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/minesweeper")
public class MinesSweeperGameController {
    private final MinesSweeperGameService minesSweeperGameService;

    @Autowired
    public MinesSweeperGameController(MinesSweeperGameService minesSweeperGameService) {
        this.minesSweeperGameService = minesSweeperGameService;
    }

    @PostMapping(value="/createGame", consumes = "application/json")
    public ResponseEntity createGame(@Valid @RequestBody MinesSweeperRequest gameRequest) {
        try {

            return ResponseEntity.status(HttpStatus.CREATED).body(minesSweeperGameService.createMinesSweeperGame(gameRequest));
        } catch (MinesSweeperException mse) {
            // log.error(":: ERROR :: Failed to create a new game exception::", mse);
            return ResponseEntity.status(HttpStatus.CONFLICT).body(mse.getMessage());
        }
    }

    @PostMapping(value = "/game/{userName}",  consumes = "application/json")
    public ResponseEntity playGame(@Valid @RequestBody MinesSweeperPlayRequest playRequest, @PathVariable String userName) {
        try {
            // Given the userName in the url path, execute the movement with row, column to that game.
            return ResponseEntity.ok(minesSweeperGameService.playMinesSweeper(userName, playRequest));
        } catch (MinesSweeperException mse) {
            // log.error(":: ERROR :: Failed to move to play for username::", userName, " exception::", mse);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(mse.getMessage());
        }
    }

    @GetMapping("{userName}")
    @ResponseBody
    @ResponseStatus
    @ApiOperation(value = "Return MinesSweeperGame by userName", response = MinesSweeperGame.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public ResponseEntity<?> getMinesSweeperGame(@PathVariable String userName) {
        return ResponseEntity.ok(minesSweeperGameService.getGameByUserName(userName));
    }


    @PutMapping(value = "/set/{userName}/redFlag", consumes = "application/json")
    public ResponseEntity setRedFlag(@Valid @RequestBody MinesSweeperPlayRequest playRequest, @PathVariable String userName) {
        try {
            // Given the userName in the url path, set the flag in row and column.
            return ResponseEntity.ok(minesSweeperGameService.setMovement(userName, playRequest, MoveType.RED_FLAG));
        } catch (MinesSweeperException mse) {
            // log.error(":: ERROR :: Failed to set a red flag in row::", playRequest.getRow(),
                            // " column::", playRequest.getColumn(), " for username::", userName, " exception::", mse);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(mse.getMessage());
        }
    }

    @PutMapping(value = "/set/{userName}/questionSymbol",  consumes = "application/json")
    public ResponseEntity setQuestionSymbol(@Valid @RequestBody MinesSweeperPlayRequest playRequest, @PathVariable String userName) {
        try {
            // Given the userName in the url path, set the question symbol in row and column.
            return ResponseEntity.ok(minesSweeperGameService.setMovement(userName, playRequest, MoveType.QUESTION_SYMBOL));
        } catch (MinesSweeperException mse) {
            // log.error(":: ERROR :: Failed to set a question symbol in row::", playRequest.getRow(),
                            // " column::", playRequest.getColumn(), " for username::", userName, " exception::", mse);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(mse.getMessage());
        }
    }
}
