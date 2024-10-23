package com.hospital.hospital.service;

import com.hospital.hospital.entity.Consultorio;
import com.hospital.hospital.entity.Paciente;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface PacienteService {

    ResponseEntity<List<Paciente>> findAll();

    ResponseEntity<Paciente> create(@RequestBody Paciente paciente);

}
