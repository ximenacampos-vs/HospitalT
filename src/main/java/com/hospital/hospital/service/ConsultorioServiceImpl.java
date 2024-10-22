package com.hospital.hospital.service;

import com.hospital.hospital.entity.Consultorio;
import com.hospital.hospital.exception.MessageConflictException;
import com.hospital.hospital.exception.MessageNotFoundException;
import com.hospital.hospital.repository.ConsultorioRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@Service(value = "consultorioService")
@Slf4j

public class ConsultorioServiceImpl implements ConsultorioService {

    private final ConsultorioRepository consultorioRepository;

    private final ModelMapper modelMapper;

    public ConsultorioServiceImpl(ConsultorioRepository consultorioRepository, ModelMapper modelMapper) {
        this.consultorioRepository = consultorioRepository;
        this.modelMapper = modelMapper;
    }

    @Override
   public ResponseEntity<List<Consultorio>> findAll() {
        List<Consultorio> consultorios = consultorioRepository.findAll();
        if (!consultorios.isEmpty()) {
            return new ResponseEntity<>(consultorios, HttpStatus.OK);
        }
        else {
            log.warn("Lista de consultorios esta vacia");
            throw new MessageNotFoundException("Lista de consultorios esta vacia");
        }
    }

    @Override
    public ResponseEntity<Consultorio> create(Consultorio consultorio) {
        if (!consultorioRepository.existsByConsultorio(consultorio.getConsultorio())) {
            consultorioRepository.save(consultorio);
            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(consultorio.getId())
                    .toUri();
            return ResponseEntity.created(location).body(consultorio);
        } else {
            throw new MessageConflictException("el consultorio ya existe");
        }
    }
}
