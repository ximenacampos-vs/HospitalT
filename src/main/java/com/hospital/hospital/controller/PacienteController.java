package com.hospital.hospital.controller;

import com.hospital.hospital.entity.Consultorio;
import com.hospital.hospital.entity.Paciente;
import com.hospital.hospital.service.PacienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paciente")

public class PacienteController {


    private final PacienteService pacienteService;


    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Paciente>> findAll() {
        return pacienteService.findAll();
    }

    @PostMapping("/create")
    public ResponseEntity<Paciente> create(@RequestBody Paciente paciente) {
        return pacienteService.create(paciente);
    }
}
