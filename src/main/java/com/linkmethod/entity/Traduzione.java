package com.linkmethod.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Traduzione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String fraseTradotta;

    @Column
    private String notaMentale;

    @Column
    private String lingua;

    @ManyToOne
    @JoinColumn(name = "frase_id", nullable = false)
    private Frase frase;
}
