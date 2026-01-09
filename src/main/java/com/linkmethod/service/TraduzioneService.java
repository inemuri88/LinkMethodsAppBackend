package com.linkmethod.service;

import com.linkmethod.dto.request.FraseCreateDTO;
import com.linkmethod.dto.request.TraduzioneCreateDTO;
import com.linkmethod.dto.request.TraduzioneUpdateDTO;
import com.linkmethod.dto.response.TraduzioneResponseDTO;
import com.linkmethod.entity.Frase;
import com.linkmethod.entity.Traduzione;

import java.util.List;

public interface TraduzioneService {

    TraduzioneResponseDTO create(TraduzioneCreateDTO dto);

    void delete(Long id);

    TraduzioneResponseDTO update(TraduzioneUpdateDTO dto);

    List<TraduzioneResponseDTO> getAllTraduzioniForFrase(Long idFrase);

    TraduzioneResponseDTO getTraduzione(Long id);

    List<Traduzione> createTraduzioneForFrase(FraseCreateDTO dto, Frase frase);
}
