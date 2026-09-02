package com.pedroska.games.controller;

import com.pedroska.games.Games;
import com.pedroska.games.GamesService;

import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("games")
public class GamesController {

    private final GamesService gamesService;

    public GamesController(GamesService gamesService){
        this.gamesService = gamesService;
    }
    @PostMapping
    public void createNewGame(@RequestBody Games games) {
        gamesService.createGame(games);
    }
    /*@DeleteMapping(path = "{id}")
    public void deleteGame(@PathVariable("id") UUID id) {
        gamesService.deleteGame(id);
    }*/
    @PutMapping(path = "{id}")
    public void UpdateGame(
            @PathVariable("id") UUID id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String category) {
        gamesService.updateGame(id, name, category);
    }


    @GetMapping("")
    public String test(){
        return "teste";
    }
}
