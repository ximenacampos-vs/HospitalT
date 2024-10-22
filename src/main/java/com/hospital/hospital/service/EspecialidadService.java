package com.hospital.hospital.service;

import com.hospital.hospital.dto.EspecialidadDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EspecialidadService {

    ResponseEntity<List<EspecialidadDto>> findAll();

}
