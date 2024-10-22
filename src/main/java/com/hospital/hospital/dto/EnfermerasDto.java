package com.hospital.hospital.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Value;

import java.io.Serializable;

@Data
public class EnfermerasDto implements Serializable {

    @NotNull
   private String codigo;

    @NotNull
    private String primer_nombre;

    private String segundo_nombre;

    @NotNull
    private String primer_apellido;

    private String segundo_apellido;
}