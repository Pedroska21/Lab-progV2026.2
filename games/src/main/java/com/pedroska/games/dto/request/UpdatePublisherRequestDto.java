package com.pedroska.games.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record UpdatePublisherRequestDto(
        @NotNull @NotEmpty
        String name,
        @NotNull @NotEmpty
        String games
) {
}
