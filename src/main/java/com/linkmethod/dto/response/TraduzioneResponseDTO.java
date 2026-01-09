package com.linkmethod.dto.response;

public record TraduzioneResponseDTO(
        Long id,
        String fraseTradotta,
        String notaMentale,
        String lingua,
        Long fraseId
) {
}
