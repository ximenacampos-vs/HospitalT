package com.hospital.hospital.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

public class Medico {

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

    @Column(nullable = false, length = 150)
    @Email
    private String email;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "especialidad")
    private Especialidad especialidad;

}
