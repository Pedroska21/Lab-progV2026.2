package com.pedroska.games.dto.request;

import jakarta.validation.constraints.NotBlank;

public record CreateAccountRequestDto(
        @NotBlank
        String email,
        @NotBlank
        String password
) {
}