package com.linkmethod.service;

import com.linkmethod.dto.request.FraseCreateDTO;
import com.linkmethod.dto.request.TraduzioneCreateDTO;
import com.linkmethod.dto.request.TraduzioneDTO;
import com.linkmethod.dto.response.TraduzioneResponseDTO;
import com.linkmethod.entity.Frase;
import com.linkmethod.entity.Traduzione;

import java.util.List;

public interface TraduzioneService {

    TraduzioneResponseDTO create(TraduzioneCreateDTO dto);

    void delete(Long id);

    TraduzioneResponseDTO update(TraduzioneDTO dto);

    List<TraduzioneResponseDTO> getAllTraduzioniForFrase(Long idFrase);

    TraduzioneResponseDTO getTraduzione(Long id);

    List<Traduzione> createTraduzioneForFrase(FraseCreateDTO dto, Frase frase);
}
