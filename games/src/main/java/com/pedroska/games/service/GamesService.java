package com.pedroska.games.service;

import com.pedroska.games.model.Games;
import java.util.UUID;
import java.util.List;

public interface GamesService {
    UUID create(Games games);
    Games update(Games games, UUID uuid);
    List<Games> findAll();
    Games findById(UUID uuid);
    void delete(UUID uuid);
}
