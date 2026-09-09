package com.pedroska.games.service;
//import jakarta.transaction.Transactional;
import com.pedroska.games.Games;
import com.pedroska.games.repository.GamesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

//import java.util.UUID;

@Service
public class GamesService {

    private final GamesRepository gamesRepository;

    public GamesService(GamesRepository gamesRepository) {
        this.gamesRepository = gamesRepository;
    }


    public Games createGame(Games games) {

        return gamesRepository.save(games);
    }

    public List<Games> findAll() {
        return gamesRepository.findAll();
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
    /*@Transactional
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
    }*/
}

