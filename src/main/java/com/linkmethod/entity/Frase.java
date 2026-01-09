package com.linkmethod.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Frase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String fraseOriginale;

    @OneToMany(mappedBy = "frase", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Traduzione> traduzioni;
}
