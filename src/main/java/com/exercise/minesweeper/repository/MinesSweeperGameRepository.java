package com.exercise.minesweeper.repository;

import com.exercise.minesweeper.model.MinesSweeperGame;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MinesSweeperGameRepository extends MongoRepository<MinesSweeperGame, String> {

    @Query("{'userName': ?0}")
    MinesSweeperGame findByUserName(String userName);
}
