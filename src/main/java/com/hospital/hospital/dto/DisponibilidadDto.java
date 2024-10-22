package com.hospital.hospital.dto;

import com.hospital.hospital.entity.Medico;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class DisponibilidadDto implements Serializable {

    @NotNull
    private Integer id;

    @NotNull
    private LocalDateTime fecha_disponibilidad;

    @NotNull
    private LocalDateTime fecha_inicio;

    @NotNull
    private LocalDateTime fecha_fin;

    @NotNull
    private ConsultorioDto consultorio;

    @NotNull
    private Medico consultorio_medico;
}