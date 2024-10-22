package com.hospital.hospital.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class CitaDto implements Serializable {

    @NotNull
    private Integer id;

    @NotNull
    private LocalDateTime fecha;

    @NotNull
    private String estado_cita;


    private String observaciones;

    @NotNull
    private PacienteDto paciente;

    @NotNull
    private MedicoDto medico;

    @NotNull
    private EnfermerasDto enfermeras;
}