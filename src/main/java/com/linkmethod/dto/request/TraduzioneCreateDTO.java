package com.linkmethod.dto.request;


public record TraduzioneCreateDTO(
         String fraseTradotta,
         String notaMentale,
         String lingua,
         Long fraseId
) {
}
