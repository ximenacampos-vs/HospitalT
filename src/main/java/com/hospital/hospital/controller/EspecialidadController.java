package com.hospital.hospital.controller;

import com.hospital.hospital.entity.Especialidad;
import com.hospital.hospital.service.EspecialidadService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/especialidad")
public class EspecialidadController {

    private final EspecialidadService especialidadService;


    public EspecialidadController(EspecialidadService especialidadService) {
        this.especialidadService = especialidadService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Especialidad>> findAll() {
        return especialidadService.findAll();
    }

    @PostMapping("/create")
    public ResponseEntity<Especialidad> create(@RequestBody Especialidad especialidad) {
        return especialidadService.create(especialidad);
    }
}
