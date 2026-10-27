package com.pedroska.games.controller;

import com.pedroska.games.dto.response.GamesResponseDto;
import com.pedroska.games.model.Games;
import com.pedroska.games.dto.request.CreateGamesRequestDto;
import com.pedroska.games.dto.request.UpdateGamesRequestDto;
import com.pedroska.games.mapper.GamesMapper;
import com.pedroska.games.service.GamesService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("games")
public class GamesController {

    private final GamesService gamesService;
    private final GamesMapper gamesMapper;

    public GamesController(GamesService gamesService, GamesMapper gamesMapper){
        this.gamesService = gamesService;
        this.gamesMapper = gamesMapper;
    }
    @GetMapping
    public ResponseEntity<List<GamesResponseDto>> list() {
        List<Games> games = gamesService.findAll();
        List<GamesResponseDto> gamesResponseDtos = gamesMapper.fromGamesToDto(games);
        return ResponseEntity.ok().body(gamesResponseDtos);
    }
    @Operation(summary = "Search game by ID")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Game found"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Game not found"
            )
    })
    @GetMapping("/{id}")
    public ResponseEntity<GamesResponseDto> findById(@PathVariable UUID uuid) {
        Games games = gamesService.findById(uuid);
        return ResponseEntity.ok().body(gamesMapper.fromGamesToDto(games));
    }
    @PutMapping
    public ResponseEntity<GamesResponseDto> update(@PathVariable UUID uuid, @RequestBody @Valid UpdateGamesRequestDto gamesDto) {
        Games games = gamesMapper.fromUpdateGamesRequestDtoToEntity(gamesDto);
        Games updated = gamesService.update(games, uuid);
        return ResponseEntity.ok().body(gamesMapper.fromGamesToDto(updated));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID uuid) {
        gamesService.delete(uuid);
        return ResponseEntity.noContent().build();
    }
         /*   @RequestBody @Valid
            (CreateGamesRequestDto dto) {
        Games games = mapper.fromCreateDtoToEntity(dto);
            UUID id = service.createGame(games).getId();
            URI location = URI.create("/games/" + id);
            return ResponseEntity.created(location).build();
        }
*/
}
