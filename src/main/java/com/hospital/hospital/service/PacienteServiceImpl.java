package com.hospital.hospital.service;


import com.hospital.hospital.entity.Paciente;
import com.hospital.hospital.exception.MessageConflictException;
import com.hospital.hospital.exception.MessageNotFoundException;
import com.hospital.hospital.repository.PacienteRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@Service(value = "pacienteService")
@Slf4j

public class PacienteServiceImpl implements PacienteService{

    private final ModelMapper modelMapper;
    private final PacienteRepository pacienteRepository;

    public PacienteServiceImpl(PacienteRepository pacienteRepository, ModelMapper modelMapper) {
        this.pacienteRepository = pacienteRepository;
        this.modelMapper = modelMapper;

    }

    @Override
    public ResponseEntity<List<Paciente>> findAll() {
        List<Paciente> pacientes = pacienteRepository.findAll();
        if (!pacientes.isEmpty()) {
            return new ResponseEntity<>(pacientes, HttpStatus.OK);
        }
        else {
            log.warn("Lista de pacientes esta vacia");
            throw new MessageNotFoundException("Lista de pacientes esta vacia");
        }
    }

    @Override
    public ResponseEntity<Paciente> create(Paciente paciente) {
        if (!pacienteRepository.existsById(paciente.getId())) {
            pacienteRepository.save(paciente);
            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(paciente.getId())
                    .toUri();
            return ResponseEntity.created(location).body(paciente);
        }else{
            throw new MessageConflictException("Paciente ya existe en el sistema");
            }
        }
    }

