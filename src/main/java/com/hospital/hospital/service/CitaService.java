package com.hospital.hospital.service;

import com.hospital.hospital.dto.CitaDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CitaService {

    ResponseEntity<List<CitaDto>> findAll();


}
