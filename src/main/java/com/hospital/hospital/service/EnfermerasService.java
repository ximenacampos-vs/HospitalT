package com.hospital.hospital.service;


import com.hospital.hospital.entity.Enfermeras;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface EnfermerasService {

    ResponseEntity<List<Enfermeras>> findAll();

    ResponseEntity<Enfermeras> create(@RequestBody Enfermeras enfermeras);

}
