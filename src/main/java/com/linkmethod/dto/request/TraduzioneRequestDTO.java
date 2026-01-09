package com.linkmethod.dto.request;

public record TraduzioneRequestDTO(
        Long id,
        String fraseTradotta,
        String notaMentale,
        String lingua,
        Long fraseId
) {
}
