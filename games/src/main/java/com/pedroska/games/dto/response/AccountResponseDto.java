package com.pedroska.games.dto.response;

import java.util.UUID;

public record AccountResponseDto(
        UUID id,
        String email
) {
}