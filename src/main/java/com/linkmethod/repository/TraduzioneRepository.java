package com.linkmethod.repository;

import com.linkmethod.entity.Traduzione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TraduzioneRepository extends JpaRepository<Traduzione, Long> {

    @Query("SELECT t FROM Traduzione t WHERE t.id = :id")
    Traduzione getTraduzioneById(Long id);

    @Query("SELECT t FROM Traduzione t WHERE t.frase.id = :idFrase")
    List<Traduzione> getAllTraduzioniForFrase(Long idFrase);

}
