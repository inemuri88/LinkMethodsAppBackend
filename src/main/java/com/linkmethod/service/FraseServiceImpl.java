package com.linkmethod.service;

import com.linkmethod.dto.request.FraseCreateDTO;
import com.linkmethod.dto.request.FraseUpdateDTO;
import com.linkmethod.dto.response.FraseResponseDTO;
import com.linkmethod.dto.response.TraduzioneResponseDTO;
import com.linkmethod.entity.Frase;
import com.linkmethod.entity.Traduzione;
import com.linkmethod.mapper.FraseMapper;
import com.linkmethod.mapper.TraduzioneMapper;
import com.linkmethod.repository.FraseRepository;
import com.linkmethod.repository.TraduzioneRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.linkmethod.util.FraseSpecialCases.FRASE_NON_TROVATA_FRASE;

@Service
@RequiredArgsConstructor
@Transactional
public class FraseServiceImpl implements FraseService{

    private final FraseRepository fraseRepository;
    private final TraduzioneMapper traduzioneMapper;
    private final FraseMapper fraseMapper;
    private final TraduzioneService traduzioneService;

    @Override
    public FraseResponseDTO create(FraseCreateDTO dto) {
        Frase frase = fraseRepository.save(new Frase(null, dto.fraseOriginale(), null));
        frase.setTraduzioni(traduzioneService.createTraduzioneForFrase(dto, frase));
        return fraseMapper.toResponseDTO(frase);
    }

    @Override
    public void delete(Long id) {
        fraseRepository.delete(fraseRepository.findById(id).orElse(FRASE_NON_TROVATA_FRASE));
    }

    @Override
    public FraseResponseDTO update(FraseUpdateDTO dto) {
        Frase frase = fraseRepository.findById(dto.id()).orElse(FRASE_NON_TROVATA_FRASE);
        frase.setFraseOriginale(dto.fraseOriginale());
        return fraseMapper.toResponseDTO(fraseRepository.save(frase));
    }

    @Override
    public List<FraseResponseDTO> getAllFrasiForFrase(String frase) {
        return fraseRepository.findByFraseOriginale(frase)
                .stream()
                .map(f -> new FraseResponseDTO(f.getId(), f.getFraseOriginale(), traduzioneMapper.toResponseDTOs(f.getTraduzioni())))
                .toList();
    }

    @Override
    public Page<FraseResponseDTO> getFrasePagination(String query, Pageable pageable) {
        return fraseRepository.findByFraseOriginalePagination(query, pageable).map(fraseMapper::toResponseDTO);
    }
}
