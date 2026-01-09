package com.linkmethod.repository;

import com.linkmethod.entity.Frase;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FraseRepository extends JpaRepository<Frase, Long> {

    @Query("SELECT f FROM Frase f WHERE f.fraseOriginale LIKE CONCAT('%', :frase, '%')")
    List<Frase> findByFraseOriginale(String frase);

    @Query("SELECT f FROM Frase f WHERE f.fraseOriginale LIKE CONCAT('%', :frase, '%')")
    Page<Frase> findByFraseOriginalePagination(@Param("frase") String frase, Pageable pageable);
}
