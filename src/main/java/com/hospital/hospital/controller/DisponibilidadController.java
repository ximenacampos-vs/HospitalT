package com.hospital.hospital.controller;


import com.hospital.hospital.entity.Disponibilidad;
import com.hospital.hospital.service.DisponibilidadService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/disponibilidad")

public class DisponibilidadController {

    private final DisponibilidadService disponibilidadService;

    public DisponibilidadController(DisponibilidadService disponibilidadService) {
        this.disponibilidadService = disponibilidadService;
    }


    @GetMapping("/all")
    public ResponseEntity<List<Disponibilidad>> findAll() {
        return disponibilidadService.findAll();
    }
}
