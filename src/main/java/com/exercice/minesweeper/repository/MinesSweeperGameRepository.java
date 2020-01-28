package com.exercice.minesweeper.repository;

import com.exercice.minesweeper.model.MinesSweeperGame;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public class MinesSweeperGameRepository implements MongoRepository<MinesSweeperGame, String> {

}
