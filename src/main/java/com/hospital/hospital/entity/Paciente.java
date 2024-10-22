package com.hospital.hospital.entity;

import com.hospital.hospital.enums.TipoDocumento;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Paciente {
    @Id
    private String id;

    @Column(nullable = false, length = 45)
    private String primer_nombre;

    @Column(nullable = true, length = 100)
    private String segundo_nombre;

    @Column(nullable = false, length = 45)
    private String primer_apellido;

    @Column(nullable = true, length = 45)
    private String segundo_apellido;

    @Column(nullable = false, length = 20)
    private String celular;

    @Column(nullable = false, length = 150)
    @Email
    private String email;

    @ElementCollection(targetClass = TipoDocumento.class)
    @CollectionTable(name = "paciente_tipo_documento", joinColumns = @JoinColumn(name = "paciente_id"))
    @Enumerated(EnumType.STRING)
    private Set<TipoDocumento> tipoDocumento;

}
