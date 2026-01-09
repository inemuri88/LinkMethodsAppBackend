package com.linkmethod.controller;


import com.linkmethod.dto.request.TraduzioneCreateDTO;
import com.linkmethod.dto.request.TraduzioneUpdateDTO;
import com.linkmethod.dto.response.TraduzioneResponseDTO;
import com.linkmethod.service.TraduzioneService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/traduzione")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class TraduzioneController {

    private final TraduzioneService traduzioneService;

    @PostMapping
    public ResponseEntity<TraduzioneResponseDTO> create(
            @Valid @RequestBody TraduzioneCreateDTO dto) {
        TraduzioneResponseDTO created = traduzioneService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        traduzioneService.delete(id);
    }

    @PutMapping("/update")
    public ResponseEntity<TraduzioneResponseDTO> update(
            @Valid @RequestBody TraduzioneUpdateDTO dto) {
        TraduzioneResponseDTO updated = traduzioneService.update(dto);
        return ResponseEntity.ok(updated);
    }

    @GetMapping("/{id}")
    public TraduzioneResponseDTO get(@PathVariable Long id){
        return traduzioneService.getTraduzione(id);
    }

    @GetMapping("/traduzioni/{id}")
    public List<TraduzioneResponseDTO> getAll(@PathVariable Long id){
        return traduzioneService.getAllTraduzioniForFrase(id);
    }
}
