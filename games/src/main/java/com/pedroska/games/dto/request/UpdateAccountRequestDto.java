package com.pedroska.games.dto.request;

import jakarta.validation.constraints.NotBlank;

public record UpdateAccountRequestDto (
        @NotBlank
        String email,
        @NotBlank
        String password
) {
        }
