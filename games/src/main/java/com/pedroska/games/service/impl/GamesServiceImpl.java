package com.pedroska.games.service.impl;

import com.pedroska.games.model.Games;
import com.pedroska.games.exception.GameAlreadyExistsException;
import com.pedroska.games.exception.GameNotFoundException;
import com.pedroska.games.repository.GamesRepository;
import com.pedroska.games.service.GamesService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class GamesServiceImpl implements GamesService {

    private final GamesRepository gamesRepository;

    public GamesServiceImpl(GamesRepository gamesRepository) {
        this.gamesRepository = gamesRepository;
    }

@Override
public UUID create(Games games) {
        if (gamesRepository.existsByName(games.getName())) {
            throw new GameAlreadyExistsException(games.getName());
        }
        return gamesRepository.save(games).getId();
}
@Override
public Games update(Games games, UUID uuid) {
    Games existing = findById(uuid);
    if (!existing.getName().equals(games.getName()) && gamesRepository.existsByName(games.getName())) {
        throw new GameAlreadyExistsException(games.getName());
    }
    existing.setName(games.getName());
    existing.setCategory(games.getCategory());
    return gamesRepository.save(existing);
    }
@Override
    public List<Games> findAll() {
        return gamesRepository.findAll();
    }
@Override
    public Games findById(UUID uuid) {
        return gamesRepository.findById(uuid)
                .orElseThrow(() -> new GameNotFoundException(uuid));
    }
@Override
    public void delete(UUID uuid) {
        if (!gamesRepository.existsById(uuid)) {
            throw new GameNotFoundException(uuid);
        }
        gamesRepository.deleteById(uuid);
    }
}

