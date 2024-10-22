package com.hospital.hospital.dto;

import com.hospital.hospital.enums.TipoDocumento;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Value;

import java.io.Serializable;
import java.util.Set;

@Data
public class PacienteDto implements Serializable {

    @NotNull
    private String id;

    @NotNull
    private String primer_nombre;

    private String segundo_nombre;

    @NotNull
    private String primer_apellido;

    private String segundo_apellido;

    @NotNull
    private String celular;

    @NotNull
    @Email
    private String email;

    @NotNull
    private  Set<TipoDocumento> tipoDocumento;
}