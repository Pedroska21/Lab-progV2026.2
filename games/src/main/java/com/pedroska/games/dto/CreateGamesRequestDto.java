package com.pedroska.games.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record CreateGamesRequestDto (
        @NotNull @NotEmpty
        String name,
        @NotNull @NotEmpty
        String category



) { }
