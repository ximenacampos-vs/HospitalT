package com.hospital.hospital.service;

import com.hospital.hospital.entity.Enfermeras;
import com.hospital.hospital.entity.Medico;
import com.hospital.hospital.entity.Paciente;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface MedicoService {

    ResponseEntity<List<Medico>> findAll();

    ResponseEntity<Medico> create(@RequestBody Medico medico);

}
