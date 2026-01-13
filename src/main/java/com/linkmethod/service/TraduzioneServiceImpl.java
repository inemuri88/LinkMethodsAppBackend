package com.linkmethod.service;

import com.linkmethod.dto.request.FraseCreateDTO;
import com.linkmethod.dto.request.TraduzioneCreateDTO;
import com.linkmethod.dto.request.TraduzioneDTO;
import com.linkmethod.dto.response.TraduzioneResponseDTO;
import com.linkmethod.entity.Frase;
import com.linkmethod.entity.Traduzione;
import com.linkmethod.mapper.TraduzioneMapper;
import com.linkmethod.repository.TraduzioneRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.linkmethod.util.TraduzioneSpecialCases.TRADUZIONE_NON_TROVATA;

@Service
@RequiredArgsConstructor
@Transactional
public class TraduzioneServiceImpl implements TraduzioneService{

    private final TraduzioneRepository traduzioneRepository;
    private  final  TraduzioneMapper traduzioneMapper;


    public TraduzioneResponseDTO getTraduzione(Long id) {
        return traduzioneRepository.findById(id)
                .map(traduzioneMapper::toResponseDTO)
                //Pattern Special Case
                .orElse(TRADUZIONE_NON_TROVATA);
    }

    public List<TraduzioneResponseDTO> getAllTraduzioniForFrase(Long idFrase){
        return traduzioneMapper.toResponseDTOs(traduzioneRepository.getAllTraduzioniForFrase(idFrase));
    }

    public TraduzioneResponseDTO create(TraduzioneCreateDTO dto){
        return traduzioneMapper.toResponseDTO(traduzioneRepository.save(traduzioneMapper.toEntity(dto)));
    }

    public List<Traduzione> createTraduzioneForFrase(FraseCreateDTO dto, Frase frase){
        return traduzioneRepository.saveAll(dto.traduzioni().stream()
                .map(t -> new Traduzione(null, t.fraseTradotta(), t.notaMentale(), t.lingua(), frase)).toList());
    }

    public void delete(Long id){
        traduzioneRepository.delete(traduzioneRepository.getTraduzioneById(id));
    }

    public TraduzioneResponseDTO update(TraduzioneDTO dto){
        Traduzione traduzione = traduzioneRepository.getTraduzioneById(dto.id());

        traduzione.setLingua(dto.lingua());
        traduzione.setFraseTradotta(dto.fraseTradotta());
        traduzione.setNotaMentale(dto.notaMentale());

        return traduzioneMapper.toResponseDTO(traduzioneRepository.save(traduzione));
    }

}
