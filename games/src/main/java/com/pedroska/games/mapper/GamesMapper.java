package com.pedroska.games.mapper;

import com.pedroska.games.Games;
import com.pedroska.games.dto.CreateGamesRequestDto;
import com.pedroska.games.dto.GamesDto;
import org.springframework.stereotype.Component;

import java.util.List;



@Component
public class GamesMapper {
    public Games fromCreateDtoToEntity(CreateGamesRequestDto dto) {
        return new Games(dto.name(), dto.category());
    }
    public List<GamesDto> toDtoList(List<Games> list) {
        return list.stream()
                .map(a -> new GamesDto(a.getName())).toList();
    }
}
