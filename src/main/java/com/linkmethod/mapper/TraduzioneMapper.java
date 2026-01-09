package com.linkmethod.mapper;

import com.linkmethod.dto.request.TraduzioneCreateDTO;
import com.linkmethod.dto.request.TraduzioneRequestDTO;
import com.linkmethod.dto.response.TraduzioneResponseDTO;
import com.linkmethod.entity.Traduzione;

import java.util.List;


public interface TraduzioneMapper {

    Traduzione toEntity(TraduzioneCreateDTO dto);

    Traduzione toEntity(TraduzioneRequestDTO dto);

    List<Traduzione> toEntities(List<TraduzioneRequestDTO> dto);

    TraduzioneResponseDTO toResponseDTO(Traduzione traduzione);

    List<TraduzioneResponseDTO> toResponseDTOs(List<Traduzione> traduzioni);

    List<TraduzioneRequestDTO> toRequestDTOs(List<Traduzione> traduzioni);

    Traduzione toEntity(TraduzioneRequestDTO dto, Long idFrase);
}
