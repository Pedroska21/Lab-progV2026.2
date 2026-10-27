package com.pedroska.games.dto.response;

import java.util.UUID;

public record GamesResponseDto (
    UUID uuid,
    String name,
    String category)
{}
