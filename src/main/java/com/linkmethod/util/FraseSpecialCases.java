package com.linkmethod.util;

import com.linkmethod.dto.response.FraseResponseDTO;
import com.linkmethod.entity.Frase;

public final class FraseSpecialCases {

    private FraseSpecialCases(){}

    public static final FraseResponseDTO FRASE_NON_TROVATA_FRASE_RESPONSE =
            new FraseResponseDTO(
                    null,
                    "FRASE NON TROVATA",
                    null
            );

    public static final Frase FRASE_NON_TROVATA_FRASE =
            new Frase(
                    null,
                    "FRASE NON TROVATA",
                    null
            );
}
