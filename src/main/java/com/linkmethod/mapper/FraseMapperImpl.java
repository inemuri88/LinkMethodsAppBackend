package com.linkmethod.mapper;

import com.linkmethod.dto.request.FraseCreateDTO;
import com.linkmethod.dto.response.FraseResponseDTO;
import com.linkmethod.entity.Frase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class FraseMapperImpl implements  FraseMapper{

    private final TraduzioneMapper traduzioneMapper;

    @Override
    public Frase toEntity(FraseCreateDTO dto) {
        return new Frase(null, dto.fraseOriginale(), traduzioneMapper.toEntities(dto.traduzioni()));
    }

    @Override
    public FraseResponseDTO toResponseDTO(Frase frase) {
        return new FraseResponseDTO(frase.getId(), frase.getFraseOriginale(), traduzioneMapper.toResponseDTOs(frase.getTraduzioni()));
    }

    @Override
    public List<FraseResponseDTO> toResponseDTOs(List<Frase> fraseList) {
        if (fraseList == null) {
            return List.of();
        }
        return fraseList.stream()
                .map(this::toResponseDTO)
                .toList();
    }

}
