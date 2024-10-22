package com.hospital.hospital.controller;

import com.hospital.hospital.dto.EspecialidadDto;
import com.hospital.hospital.service.EspecialidadService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/especialidad")
public class EspecialidadController {

    private final EspecialidadService especialidadService;


    public EspecialidadController(EspecialidadService especialidadService) {
        this.especialidadService = especialidadService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<EspecialidadDto>> findAll() {
        return especialidadService.findAll();
    }
}
