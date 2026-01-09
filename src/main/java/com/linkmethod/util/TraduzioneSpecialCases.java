package com.linkmethod.util;

import com.linkmethod.dto.response.TraduzioneResponseDTO;

public final class TraduzioneSpecialCases {

    private TraduzioneSpecialCases() {}

    public static final TraduzioneResponseDTO TRADUZIONE_NON_TROVATA =
            new TraduzioneResponseDTO(
                    null,
                    "TRADUZIONE NON TROVATA",
                    "",
                    "",
                    null
            );
}