package com.hospital.hospital.controller;

import com.hospital.hospital.entity.Medico;
import com.hospital.hospital.entity.Paciente;
import com.hospital.hospital.service.MedicoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medico")
public class MedicoController {

    private final MedicoService medicoService;


    public MedicoController(MedicoService medicoService) {
        this.medicoService = medicoService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Medico>> findAll() {
        return medicoService.findAll();
    }

    @PostMapping("/create")
    public ResponseEntity<Medico> create(@RequestBody Medico medico) {
        return medicoService.create(medico);
    }
}
