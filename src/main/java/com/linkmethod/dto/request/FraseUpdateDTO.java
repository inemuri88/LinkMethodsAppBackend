package com.linkmethod.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record FraseUpdateDTO(
        Long id,
        @NotNull @NotBlank @NotEmpty String fraseOriginale,
        List<TraduzioneDTO> traduzioni
) {
}
