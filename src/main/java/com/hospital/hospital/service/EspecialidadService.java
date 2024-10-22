package com.hospital.hospital.service;

import com.hospital.hospital.entity.Especialidad;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface EspecialidadService {

    ResponseEntity<List<Especialidad>> findAll();

    ResponseEntity<Especialidad> create(@RequestBody Especialidad especialidad);

}
