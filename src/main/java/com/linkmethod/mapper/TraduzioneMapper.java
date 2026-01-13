package com.linkmethod.mapper;

import com.linkmethod.dto.request.TraduzioneCreateDTO;
import com.linkmethod.dto.request.TraduzioneDTO;
import com.linkmethod.dto.response.TraduzioneResponseDTO;
import com.linkmethod.entity.Traduzione;

import java.util.List;


public interface TraduzioneMapper {

    Traduzione toEntity(TraduzioneCreateDTO dto);

    Traduzione toEntity(TraduzioneDTO dto);

    List<Traduzione> toEntities(List<TraduzioneDTO> dto);

    TraduzioneResponseDTO toResponseDTO(Traduzione traduzione);

    List<TraduzioneResponseDTO> toResponseDTOs(List<Traduzione> traduzioni);

    List<TraduzioneDTO> toRequestDTOs(List<Traduzione> traduzioni);

    Traduzione toEntity(TraduzioneDTO dto, Long idFrase);
}
