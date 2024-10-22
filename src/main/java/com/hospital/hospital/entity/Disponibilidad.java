package com.hospital.hospital.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

public class Disponibilidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, columnDefinition = "TIMESTAMP")
    private LocalDateTime fecha_disponibilidad;

    @Column(nullable = false, columnDefinition = "TIMESTAMP")
    private LocalDateTime fecha_inicio;

    @Column(nullable = false, columnDefinition = "TIMESTAMP")
    private LocalDateTime fecha_fin;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "consultorio_id")
    private Consultorio consultorio;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "medico_codigo")
    private Medico consultorio_medico;



}

