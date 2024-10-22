package com.hospital.hospital.controller;

import com.hospital.hospital.dto.MedicoDto;
import com.hospital.hospital.dto.PacienteDto;
import com.hospital.hospital.service.MedicoService;
import com.hospital.hospital.service.PacienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/medico")
public class MedicoController {

    private final MedicoService medicoService;


    public MedicoController(MedicoService medicoService) {
        this.medicoService = medicoService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<MedicoDto>> findAll() {
        return medicoService.findAll();
    }
}