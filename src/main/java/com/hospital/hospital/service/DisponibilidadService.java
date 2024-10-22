package com.hospital.hospital.service;

import com.hospital.hospital.entity.Disponibilidad;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DisponibilidadService {

    ResponseEntity<List<Disponibilidad>> findAll();

}
