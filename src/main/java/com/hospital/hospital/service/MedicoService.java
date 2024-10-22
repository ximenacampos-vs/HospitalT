package com.hospital.hospital.service;

import com.hospital.hospital.dto.MedicoDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MedicoService {

    ResponseEntity<List<MedicoDto>> findAll();

}
