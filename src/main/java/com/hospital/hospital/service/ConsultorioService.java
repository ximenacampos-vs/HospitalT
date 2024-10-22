package com.hospital.hospital.service;

import com.hospital.hospital.entity.Consultorio;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ConsultorioService {

    ResponseEntity<List<Consultorio>> findAll();

    ResponseEntity<Consultorio> create(@RequestBody Consultorio consultorio);

}
