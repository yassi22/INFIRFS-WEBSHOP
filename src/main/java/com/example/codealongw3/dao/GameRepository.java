package com.example.codealongw3.dao;

import com.example.codealongw3.models.Game;
import com.example.codealongw3.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
    Optional<List<Game>> findByGenreId(long id);
}
