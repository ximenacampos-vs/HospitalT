package com.hospital.hospital.service;

import com.hospital.hospital.entity.Enfermeras;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EnfermerasService {

    ResponseEntity<List<Enfermeras>> findAll();

}
