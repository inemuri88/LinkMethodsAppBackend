package com.linkmethod.dto.request;

public record TraduzioneUpdateDTO(
        Long id,
        String fraseTradotta,
        String notaMentale,
        String lingua,
        Long fraseId
) {
}
