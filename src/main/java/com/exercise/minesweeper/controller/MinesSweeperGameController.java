package com.exercise.minesweeper.controller;

import com.exercise.minesweeper.exception.MinesSweeperException;
import com.exercise.minesweeper.model.MinesSweeperGame;
import com.exercise.minesweeper.model.MinesSweeperRequest;
import com.exercise.minesweeper.service.MinesSweeperGameService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(value="MinesWeeper Game", description="Let's start playing the MinesWeeper game")
@RestController
@Validated
@Slf4j
@RequestMapping("/minesweeper/api")
public class MinesSweeperGameController {
    private final MinesSweeperGameService minesSweeperGameService;

    @Autowired
    public MinesSweeperGameController(MinesSweeperGameService minesSweeperGameService) {
        this.minesSweeperGameService = minesSweeperGameService;
    }

    @ResponseBody
    @ResponseStatus
    @ApiOperation(value = "Return MinesSweeperGame created", response = MinesSweeperGame.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successfully created")
    })
    @PostMapping(value="/createGame", consumes = "application/json")
    public ResponseEntity createGame(@Valid @RequestBody MinesSweeperRequest gameRequest) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(minesSweeperGameService.createMinesSweeperGame(gameRequest));
        } catch (MinesSweeperException mse) {
            log.error(":: ERROR :: Failed to create a new game exception::", mse);
            return ResponseEntity.status(HttpStatus.CONFLICT).body(mse.getMessage());
        }
    }

    @GetMapping("/resume/{gameId}")
    @ResponseBody
    @ResponseStatus
    @ApiOperation(value = "Return MinesSweeperGame by gameId", response = MinesSweeperGame.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public ResponseEntity<?> getMinesSweeperGameById(@PathVariable String gameId) {
        return ResponseEntity.ok(minesSweeperGameService.getGameById(gameId));
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

    @ResponseBody
    @ResponseStatus
    @ApiOperation(value = "Return the saved Game", response = MinesSweeperGame.class)
    @PutMapping(value = "/save/{userName}", consumes = "application/json")
    public ResponseEntity saveGame(@Valid @RequestBody MinesSweeperGame minesSweeperGame, @PathVariable String userName) {
        try {
            // Given the userName in the url path, set the flag in row and column.
            return ResponseEntity.ok(minesSweeperGameService.saveMovement(userName, minesSweeperGame));
        } catch (MinesSweeperException mse) {
            log.error(":: ERROR :: Failed to save the minesSweeperGame with Id::", minesSweeperGame.getId(),
                            " for username::", userName, " exception::", mse);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(mse.getMessage());
        }
    }

    @ResponseBody
    @ResponseStatus
    @ApiOperation(value = "Return the paused Game", response = MinesSweeperGame.class)
    @PutMapping(value = "/pause/{gameId}", consumes = "application/json")
    public ResponseEntity pauseGame(@PathVariable String gameId) {
        try {
            // Given the userName in the url path, set the flag in row and column.
            return ResponseEntity.ok(minesSweeperGameService.pauseGame(gameId));
        } catch (MinesSweeperException mse) {
            log.error(":: ERROR :: Failed to pause the minesSweeperGame with Id::", gameId, " exception::", mse);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(mse.getMessage());
        }
    }

    @ResponseBody
    @ResponseStatus
    @ApiOperation(value = "Return OK if the Game is Over", response = MinesSweeperGame.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully deleted"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @DeleteMapping(value = "/stop/{id}")
    public ResponseEntity gameOver(@PathVariable String id) {
        try {
            // Given the userName in the url path, finish and delete the game.
            minesSweeperGameService.gameOver(id);
            return ResponseEntity.ok(HttpStatus.OK);
        } catch (MinesSweeperException mse) {
            log.error(":: ERROR :: Failed to delete the game for this id::", id, " exception::", mse);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(mse.getMessage());
        }
    }
}
