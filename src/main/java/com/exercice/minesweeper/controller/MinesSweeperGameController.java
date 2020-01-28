package com.exercice.minesweeper.controller;

import com.exercice.minesweeper.model.MinesSweeperRequest;
import com.exercice.minesweeper.service.MinesSweeperGameService;
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
        } catch () {
            // log.error(":: ERROR:: Failed to create a new game exception", e);
            return ResponseEntity.status(HttpStatus.CONFLICT).body("ERROR");
        }
    }

    @GetMapping("{userName}")
    public ResponseEntity<?> getMinesSweeperGame(@PathVariable String userName) {
        return ResponseEntity.ok(minesSweeperGameService.getGameByUserName(userName));
    }
}
