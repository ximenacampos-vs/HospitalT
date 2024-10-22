package com.hospital.hospital.service;

import com.hospital.hospital.entity.Medico;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MedicoService {

    ResponseEntity<List<Medico>> findAll();

}
