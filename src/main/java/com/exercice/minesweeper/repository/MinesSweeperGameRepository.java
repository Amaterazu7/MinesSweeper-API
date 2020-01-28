package com.exercice.minesweeper.repository;

import com.exercice.minesweeper.model.MinesSweeperGame;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MinesSweeperGameRepository implements MongoRepository<MinesSweeperGame, String> {

    @Override
    public <S extends MinesSweeperGame> S save(S s) {
        return null;
    }

    @Override
    public <S extends MinesSweeperGame> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<MinesSweeperGame> findById(String s) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(String s) {
        return false;
    }

    @Override
    public List<MinesSweeperGame> findAll() {
        return null;
    }

    @Override
    public Iterable<MinesSweeperGame> findAllById(Iterable<String> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(String s) {

    }

    @Override
    public void delete(MinesSweeperGame minesSweeperGame) {

    }

    @Override
    public void deleteAll(Iterable<? extends MinesSweeperGame> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<MinesSweeperGame> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<MinesSweeperGame> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public <S extends MinesSweeperGame> S insert(S s) {
        return null;
    }

    @Override
    public <S extends MinesSweeperGame> List<S> insert(Iterable<S> iterable) {
        return null;
    }

    @Override
    public <S extends MinesSweeperGame> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends MinesSweeperGame> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends MinesSweeperGame> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends MinesSweeperGame> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends MinesSweeperGame> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends MinesSweeperGame> boolean exists(Example<S> example) {
        return false;
    }
}
