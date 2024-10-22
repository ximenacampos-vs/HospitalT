package com.hospital.hospital.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

public class Enfermeras {

    @Id
    private String codigo;

    @Column(nullable = false, length = 45)
    private String primer_nombre;

    @Column(nullable = true, length = 100)
    private String segundo_nombre;

    @Column(nullable = false, length = 45)
    private String primer_apellido;

    @Column(nullable = true, length = 45)
    private String segundo_apellido;

}
