package com.pedroska.games.repository;

import com.pedroska.games.model.Publisher;
import java.util.UUID;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherRepository extends JpaRepository <Publisher, UUID>{
    boolean existsByName(String name);
    Optional<Publisher> findByName(String name);
}
