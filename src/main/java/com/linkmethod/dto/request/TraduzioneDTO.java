package com.linkmethod.dto.request;

public record TraduzioneDTO(
        Long id,
        String fraseTradotta,
        String notaMentale,
        String lingua,
        Long fraseId
) {
}
