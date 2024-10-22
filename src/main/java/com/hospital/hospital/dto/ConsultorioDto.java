package com.hospital.hospital.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Value;

import java.io.Serializable;

@Data
public class ConsultorioDto implements Serializable {

    @NotNull
    private Integer id;

    @NotNull
    private String consultorio;
}