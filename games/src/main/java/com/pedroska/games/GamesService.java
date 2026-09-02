package com.pedroska.games;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class GamesService {

    private final GamesRepository gamesRepository;

    public GamesService(GamesRepository gamesRepository) {
        this.gamesRepository = gamesRepository;
    }
    /*public void deleteGame(UUID id) {
        boolean exists = gamesRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException(
                    "Game with id" + id + "does not exist"
            );
        }
        gamesRepository.deleteById(id);
    } */


    public void createGame(Games games) {
        System.out.println(games);
    }
    @Transactional
    public void updateGame(UUID id, String name, String category) {
    Games games = gamesRepository.findById(id).orElseThrow(() -> new IllegalStateException("Game with id" + id + "does not exist"));
        if (name != null
        ) {
            Games.setName(name);
        }
        if (category != null
        ) {
            Games.setCategory(category);
        }
    }
}

