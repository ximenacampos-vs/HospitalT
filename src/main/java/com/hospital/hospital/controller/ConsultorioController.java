package com.hospital.hospital.controller;

import com.hospital.hospital.dto.ConsultorioDto;
import com.hospital.hospital.dto.PacienteDto;
import com.hospital.hospital.service.ConsultorioService;
import com.hospital.hospital.service.PacienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/consultorio")

public class ConsultorioController {
    
    private final ConsultorioService consultorioService;

    public ConsultorioController(ConsultorioService consultorioService) {
        this.consultorioService = consultorioService;
    }


    @GetMapping("/all")
    public ResponseEntity<List<ConsultorioDto>> findAll() {
        return consultorioService.findAll();
    }
}
