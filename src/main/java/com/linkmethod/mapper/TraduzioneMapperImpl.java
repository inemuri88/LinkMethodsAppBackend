package com.linkmethod.mapper;

import com.linkmethod.dto.request.TraduzioneCreateDTO;
import com.linkmethod.dto.request.TraduzioneDTO;
import com.linkmethod.dto.response.TraduzioneResponseDTO;
import com.linkmethod.entity.Frase;
import com.linkmethod.entity.Traduzione;
import com.linkmethod.repository.FraseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.linkmethod.util.FraseSpecialCases.FRASE_NON_TROVATA_FRASE;

@Component
@RequiredArgsConstructor
public class TraduzioneMapperImpl implements TraduzioneMapper{

    private final FraseRepository fraseRepository;

    @Override
    public Traduzione toEntity(TraduzioneCreateDTO dto) {
        Frase frase =  fraseRepository.findById(dto.fraseId()).orElse(FRASE_NON_TROVATA_FRASE);
        return  new Traduzione(
                null,
                dto.fraseTradotta(),
                dto.notaMentale(),
                dto.lingua(),
                frase
        );
    }

    @Override
    public Traduzione toEntity(TraduzioneDTO dto) {
        Frase frase = fraseRepository.findById(dto.fraseId()).orElse(FRASE_NON_TROVATA_FRASE);
        return new Traduzione(dto.id(), dto.fraseTradotta(), dto.notaMentale(), dto.lingua(), frase);
    }

    @Override
    public List<Traduzione> toEntities(List<TraduzioneDTO> dtos) {

        return dtos.stream()
                .map(t -> {
                    Frase frase = fraseRepository.findById(t.fraseId()).orElse(FRASE_NON_TROVATA_FRASE);
                    return new Traduzione(
                            t.id(),
                            t.fraseTradotta(),
                            t.notaMentale(),
                            t.lingua(),
                            frase
                    );
                })
                .toList();
    }

    @Override
    public Traduzione toEntity(TraduzioneDTO dto, Long idFrase) {
        Frase frase =  fraseRepository.findById(idFrase).orElse(FRASE_NON_TROVATA_FRASE);
        return  new Traduzione(
                null,
                dto.fraseTradotta(),
                dto.notaMentale(),
                dto.lingua(),
                frase
        );
    }

    @Override
    public TraduzioneResponseDTO toResponseDTO(Traduzione traduzione) {
        return new TraduzioneResponseDTO(
                traduzione.getId(),
                traduzione.getFraseTradotta(),
                traduzione.getNotaMentale(),
                traduzione.getLingua(),
                traduzione.getFrase().getId()
        );
    }

    @Override
    public List<TraduzioneResponseDTO> toResponseDTOs(List<Traduzione> traduzioni) {
        return traduzioni.stream()
                .map(t -> new TraduzioneResponseDTO(
                        t.getId(),
                        t.getFraseTradotta(),
                        t.getNotaMentale(),
                        t.getLingua(),
                        t.getFrase().getId()
                ))
                .toList();
    }

    @Override
    public List<TraduzioneDTO> toRequestDTOs(List<Traduzione> traduzioni) {
        return traduzioni.stream().map(t -> new TraduzioneDTO(
                t.getId(),
                t.getFraseTradotta(),
                t.getNotaMentale(),
                t.getLingua(),
                t.getFrase().getId())
        ).toList();
    }
}
