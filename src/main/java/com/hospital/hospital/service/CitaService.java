package com.hospital.hospital.service;


import com.hospital.hospital.entity.Cita;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CitaService {

    ResponseEntity<List<Cita>> findAll();


}
