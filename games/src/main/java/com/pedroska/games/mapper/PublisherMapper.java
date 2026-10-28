package com.pedroska.games.mapper;

import com.pedroska.games.dto.response.PublisherResponseDto;
import com.pedroska.games.dto.request.UpdatePublisherRequestDto;
import com.pedroska.games.model.Publisher;
import com.pedroska.games.dto.request.CreatePublisherRequestDto;

import org.springframework.stereotype.Component;

import java.util.List;



@Component
public class PublisherMapper {

    public Publisher fromCreatePublisherRequestDtoToEntity(CreatePublisherRequestDto publisherDto) {
        return Publisher.builder()
                .name(publisherDto.name())
                .games(publisherDto.games())
                .build();
    }
    public Publisher fromUpdatePublisherRequestDtoToEntity(UpdatePublisherRequestDto publisherDto){
        return Publisher.builder()
                .name(publisherDto.name())
                .games(publisherDto.games())
                .build();
    }
    public PublisherResponseDto fromPublisherToDto(Publisher publisher) {
        return new PublisherResponseDto(
                publisher.getId(),
                publisher.getName(),
                publisher.getGames()
        );
    }
    public List<PublisherResponseDto> fromPublisherToDto(List<Publisher> publisher) {
        return publisher.stream()
                .map(this::fromPublisherToDto)
                .toList();
    }
}
