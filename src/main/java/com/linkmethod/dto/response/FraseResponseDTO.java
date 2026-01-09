package com.linkmethod.dto.response;

import java.util.List;

public record FraseResponseDTO(
         Long id,
         String fraseOriginale,
         List<TraduzioneResponseDTO> traduzioni
) {
}
