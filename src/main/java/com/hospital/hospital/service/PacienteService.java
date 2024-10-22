package com.hospital.hospital.service;

import com.hospital.hospital.dto.PacienteDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PacienteService {

    ResponseEntity<List<PacienteDto>> findAll();

}
