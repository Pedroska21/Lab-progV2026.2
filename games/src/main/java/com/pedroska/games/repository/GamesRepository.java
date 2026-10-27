package com.pedroska.games.repository;

import com.pedroska.games.model.Games;
import java.util.UUID;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GamesRepository extends JpaRepository <Games, UUID>{
    boolean existsByName(String name);
    Optional<Games> findByName(String name);
}
