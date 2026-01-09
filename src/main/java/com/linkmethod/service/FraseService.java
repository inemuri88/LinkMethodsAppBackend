package com.linkmethod.service;

import com.linkmethod.dto.request.FraseCreateDTO;
import com.linkmethod.dto.request.FraseUpdateDTO;
import com.linkmethod.dto.response.FraseResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface FraseService {

    FraseResponseDTO create(FraseCreateDTO dto);

    void delete(Long id);

    FraseResponseDTO update(FraseUpdateDTO dto);

    List<FraseResponseDTO> getAllFrasiForFrase(String frase);

    Page<FraseResponseDTO> getFrasePagination(String query,Pageable pageable);


}
