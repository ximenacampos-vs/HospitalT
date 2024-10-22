package com.hospital.hospital.service;

import com.hospital.hospital.dto.ConsultorioDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ConsultorioService {

    ResponseEntity<List<ConsultorioDto>> findAll();

}
