package com.linkmethod.controller;

import com.linkmethod.dto.request.FraseCreateDTO;
import com.linkmethod.dto.request.FraseUpdateDTO;
import com.linkmethod.dto.response.FraseResponseDTO;
import com.linkmethod.service.FraseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/frase")
@RequiredArgsConstructor
@CrossOrigin(origins = {
        "http://localhost:4200",
        "http://localhost:5501",
        "http://127.0.0.1:5501"
})
public class FraseController {

    private final FraseService fraseService;

    @GetMapping("/{frase}")
    public ResponseEntity<List<FraseResponseDTO>> get(@PathVariable String frase){
        return ResponseEntity.status(HttpStatus.OK).body(fraseService.getAllFrasiForFrase(frase));
    }

    @GetMapping("/frasi")
    public ResponseEntity<Page<FraseResponseDTO>> getPagination(@RequestParam String query,
                                                Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(fraseService.getFrasePagination(query, pageable));
    }

    @PostMapping
    public ResponseEntity<FraseResponseDTO> create(
            @Valid @RequestBody FraseCreateDTO dto) {
        FraseResponseDTO created = fraseService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        fraseService.delete(id);
    }

    @PutMapping
    public ResponseEntity<FraseResponseDTO> update(
            @Valid @RequestBody FraseUpdateDTO dto) {
        FraseResponseDTO updated = fraseService.update(dto);
        return ResponseEntity.ok(updated);
    }
}
