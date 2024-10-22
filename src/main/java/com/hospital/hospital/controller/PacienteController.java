package com.hospital.hospital.controller;


import com.hospital.hospital.dto.EspecialidadDto;
import com.hospital.hospital.dto.PacienteDto;
import com.hospital.hospital.service.EspecialidadService;
import com.hospital.hospital.service.PacienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/paciente")

public class PacienteController {


    private final PacienteService pacienteService;


    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<PacienteDto>> findAll() {
        return pacienteService.findAll();
    }

}
