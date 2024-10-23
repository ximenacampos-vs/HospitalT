package com.hospital.hospital.controller;


import com.hospital.hospital.entity.Cita;
import com.hospital.hospital.entity.Enfermeras;
import com.hospital.hospital.service.CitaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/create")
    public ResponseEntity<Cita> create(@RequestBody Cita cita){
        return citaService.create(cita);
    }
}
