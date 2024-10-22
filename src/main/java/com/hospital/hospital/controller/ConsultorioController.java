package com.hospital.hospital.controller;

import com.hospital.hospital.entity.Consultorio;
import com.hospital.hospital.service.ConsultorioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consultorio")

public class ConsultorioController {
    
    private final ConsultorioService consultorioService;

    public ConsultorioController(ConsultorioService consultorioService) {
        this.consultorioService = consultorioService;
    }


    @GetMapping("/all")
    public ResponseEntity<List<Consultorio>> findAll() {
        return consultorioService.findAll();
    }

    @PostMapping("/create")
    public ResponseEntity<Consultorio> create(@RequestBody Consultorio consultorio) {
        return consultorioService.create(consultorio);
    }
}
