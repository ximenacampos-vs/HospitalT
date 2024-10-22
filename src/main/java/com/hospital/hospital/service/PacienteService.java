package com.hospital.hospital.service;

import com.hospital.hospital.entity.Paciente;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PacienteService {

    ResponseEntity<List<Paciente>> findAll();

}
