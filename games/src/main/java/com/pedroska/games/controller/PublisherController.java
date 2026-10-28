package com.pedroska.games.controller;

import com.pedroska.games.mapper.PublisherMapper;
import com.pedroska.games.service.PublisherService;
import com.pedroska.games.model.Publisher;
import com.pedroska.games.dto.request.CreatePublisherRequestDto;
import com.pedroska.games.dto.request.UpdatePublisherRequestDto;
import com.pedroska.games.dto.response.PublisherResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("publisher")
public class PublisherController {

    private final PublisherService publisherService;

    private final PublisherMapper publisherMapper;

    public PublisherController(PublisherService publisherService, PublisherMapper publisherMapper){
        this.publisherService = publisherService;
        this.publisherMapper = publisherMapper;
    }
    @GetMapping
    public ResponseEntity<List<PublisherResponseDto>> list() {
        List<Publisher> publisher = publisherService.findAll();
        List<PublisherResponseDto> publisherResponseDtos = publisherMapper.fromPublisherToDto(publisher);
        return ResponseEntity.ok().body(publisherResponseDtos);
    }
    @Operation(summary = "Search publisher by ID")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Publisher found"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Publisher not found"
            )
    })
    @GetMapping("/{id}")
    public ResponseEntity<PublisherResponseDto> findById(@PathVariable UUID uuid) {
        Publisher publisher = publisherService.findById(uuid);
        return ResponseEntity.ok().body(publisherMapper.fromPublisherToDto(publisher));
    }
    @PutMapping
    public ResponseEntity<PublisherResponseDto> update(@PathVariable UUID uuid, @RequestBody @Valid UpdatePublisherRequestDto publisherDto) {
        Publisher publisher = publisherMapper.fromUpdatePublisherRequestDtoToEntity(publisherDto);
       Publisher updated = publisherService.update(publisher, uuid);
        return ResponseEntity.ok().body(publisherMapper.fromPublisherToDto(updated));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID uuid) {
        publisherService.delete(uuid);
        return ResponseEntity.noContent().build();
    }

}
