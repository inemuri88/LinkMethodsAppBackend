package com.linkmethod.mapper;

import com.linkmethod.dto.request.FraseCreateDTO;
import com.linkmethod.dto.response.FraseResponseDTO;
import com.linkmethod.entity.Frase;

import java.util.List;

public interface FraseMapper {

    Frase toEntity(FraseCreateDTO dto);

    FraseResponseDTO toResponseDTO(Frase frase);

    List<FraseResponseDTO> toResponseDTOs(List<Frase> fraseList);
}
