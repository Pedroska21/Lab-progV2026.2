package com.pedroska.games.dto.response;

import java.util.UUID;

public record PublisherResponseDto(
    UUID uuid,
    String name,
    String games)
{}
