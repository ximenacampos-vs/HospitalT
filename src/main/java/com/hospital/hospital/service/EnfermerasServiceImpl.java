package com.hospital.hospital.service;


import com.hospital.hospital.entity.Enfermeras;
import com.hospital.hospital.exception.MessageConflictException;
import com.hospital.hospital.exception.MessageNotFoundException;
import com.hospital.hospital.repository.EnfermerasRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@Service(value = "enfermerasService")
@Slf4j

public class EnfermerasServiceImpl implements EnfermerasService {

    private final EnfermerasRepository enfermerasRepository;

    private final ModelMapper modelMapper;

    public EnfermerasServiceImpl(EnfermerasRepository enfermerasRepository, ModelMapper modelMapper) {
        this.enfermerasRepository = enfermerasRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ResponseEntity<List<Enfermeras>> findAll() {
        List<Enfermeras> enfermera = enfermerasRepository.findAll();
        if (!enfermera.isEmpty()) {
            return new ResponseEntity<>(enfermera, HttpStatus.OK);
        }
        else {
            log.warn("Lista de enfermeras esta vacia");
            throw new MessageNotFoundException("Lista de enfermeras esta vacia");
        }
    }

    @Override
    public ResponseEntity<Enfermeras> create(Enfermeras enfermeras) {
        if (!enfermerasRepository.existsByCodigo(enfermeras.getCodigo())) {
            enfermerasRepository.save(enfermeras);
            URI location = ServletUriComponentsBuilder
                  .fromCurrentRequest()
                  .path("/{id}")
                    .buildAndExpand(enfermeras.getCodigo())
                  .toUri();
            return ResponseEntity.created(location).body(enfermeras);
        }else{
            throw new MessageConflictException("Enfermeras ya existe en el sistema");
        }

    }

}
