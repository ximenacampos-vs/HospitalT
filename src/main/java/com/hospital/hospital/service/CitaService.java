package com.hospital.hospital.service;


import com.hospital.hospital.entity.Cita;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface CitaService {

    ResponseEntity<List<Cita>> findAll();

    ResponseEntity<Cita> create(@RequestBody Cita cita);

}
