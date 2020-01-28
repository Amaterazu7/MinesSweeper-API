package com.exercice.minesweeper.controller;

import com.exercice.minesweeper.exception.MinesSweeperException;
import com.exercice.minesweeper.model.MinesSweeperGame;
import com.exercice.minesweeper.model.MinesSweeperRequest;
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
        } catch (MinesSweeperException e) {
            // log.error(":: ERROR:: Failed to create a new game exception", e);
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
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
}
