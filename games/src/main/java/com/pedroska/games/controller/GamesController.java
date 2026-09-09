package com.pedroska.games.controller;

import com.pedroska.games.Games;
import com.pedroska.games.dto.CreateGamesRequestDto;
import com.pedroska.games.dto.GamesDto;
import com.pedroska.games.mapper.GamesMapper;
import com.pedroska.games.service.GamesService;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("games")
public class GamesController {

    private final GamesService service;
    private final GamesMapper mapper;

    public GamesController(GamesService service, GamesMapper mapper){
        this.service = service;
        this.mapper = mapper;
    }
    @GetMapping
    public ResponseEntity<List<GamesDto>> list() {
        List<Games> games = service.findAll();
        var dtos = mapper.toDtoList(games);
        return ResponseEntity.ok().body(dtos);
    }
    @PostMapping
    public ResponseEntity<Void> create (
            @RequestBody @Valid
            CreateGamesRequestDto dto) {
        Games games = mapper.fromCreateDtoToEntity(dto);
            UUID id = service.createGame(games).getId();
            URI location = URI.create("/games/" + id);
            return ResponseEntity.created(location).build();
        }

    }
