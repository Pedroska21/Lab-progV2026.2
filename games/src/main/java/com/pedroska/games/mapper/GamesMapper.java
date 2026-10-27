package com.pedroska.games.mapper;

import com.pedroska.games.dto.response.GamesResponseDto;
import com.pedroska.games.dto.request.UpdateGamesRequestDto;
import com.pedroska.games.model.Games;
import com.pedroska.games.dto.request.CreateGamesRequestDto;

import org.springframework.stereotype.Component;

import java.util.List;



@Component
public class GamesMapper {

    public Games fromCreateGamesRequestDtoToEntity(CreateGamesRequestDto gamesDto) {
    return Games.builder()
            .name(gamesDto.name())
            .category(gamesDto.category())
            .build();
    }
    public Games fromUpdateGamesRequestDtoToEntity(UpdateGamesRequestDto gamesDto){
        return Games.builder()
        .name(gamesDto.name())
        .category(gamesDto.category())
        .build();
    }
    public GamesResponseDto fromGamesToDto(Games games) {
        return new GamesResponseDto(
                games.getId(),
                games.getName(),
                games.getCategory()
        );
    }
    public List<GamesResponseDto> fromGamesToDto(List<Games> games) {
        return games.stream()
                .map(this::fromGamesToDto)
                .toList();
    }
}
