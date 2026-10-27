package com.pedroska.games.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotEmpty;

public record UpdateGamesRequestDto (
        @NotNull @NotEmpty
        String name,
        @NotNull @NotEmpty
        String category
) {
}
