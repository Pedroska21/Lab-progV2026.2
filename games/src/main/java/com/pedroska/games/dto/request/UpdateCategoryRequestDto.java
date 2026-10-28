package com.pedroska.games.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record UpdateCategoryRequestDto(
        @NotNull @NotEmpty
        String name
) {
}
