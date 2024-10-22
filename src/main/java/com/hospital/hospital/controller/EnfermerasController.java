package com.hospital.hospital.controller;

import com.hospital.hospital.entity.Enfermeras;
import com.hospital.hospital.service.EnfermerasService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/enfermeras")

public class EnfermerasController {

    private final EnfermerasService enfermerasService;

    public EnfermerasController(EnfermerasService enfermerasService) {
        this.enfermerasService = enfermerasService;
    }


    @GetMapping("/all")
    public ResponseEntity<List<Enfermeras>> findAll() {
        return enfermerasService.findAll();
    }
}
