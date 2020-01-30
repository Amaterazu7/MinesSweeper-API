package com.exercise.minesweeper.repository;

import com.exercise.minesweeper.model.MinesSweeperBoard;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MinesSweeperBoardRepository extends MongoRepository<MinesSweeperBoard, String> {
}
