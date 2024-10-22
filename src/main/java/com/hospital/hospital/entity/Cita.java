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

public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, columnDefinition = "TIMESTAMP")
    private LocalDateTime fecha;

    @Column(nullable = true, length = 45)
    private String estado_cita;

    @Column(nullable = true, length = 45)
    private String observaciones;

    @Getter
    @OneToOne(cascade = CascadeType.ALL, optional = false)
    private Paciente paciente;

    @Getter
    @OneToOne(cascade = CascadeType.ALL, optional = false)
    private Medico medico;

    @Getter
    @OneToOne(cascade = CascadeType.ALL, optional = false)
    private Enfermeras enfermeras;

}
