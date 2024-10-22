package com.hospital.hospital.service;

import com.hospital.hospital.dto.DisponibilidadDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DisponibilidadService {

    ResponseEntity<List<DisponibilidadDto>> findAll();

}
