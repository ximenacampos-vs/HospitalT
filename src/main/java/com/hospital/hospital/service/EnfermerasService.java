package com.hospital.hospital.service;

import com.hospital.hospital.dto.EnfermerasDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EnfermerasService {

    ResponseEntity<List<EnfermerasDto>> findAll();

}
