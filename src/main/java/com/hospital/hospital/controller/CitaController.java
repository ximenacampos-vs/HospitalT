package com.hospital.hospital.controller;


import com.hospital.hospital.entity.Cita;
import com.hospital.hospital.service.CitaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cita")

public class CitaController {

    private final CitaService citaService;

    public CitaController(CitaService citaService) {
        this.citaService = citaService;
    }


    @GetMapping("/all")
    public ResponseEntity<List<Cita>> findAll() {
        return citaService.findAll();
    }
}
