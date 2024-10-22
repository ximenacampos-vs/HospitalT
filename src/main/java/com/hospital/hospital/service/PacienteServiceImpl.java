package com.hospital.hospital.service;

import com.hospital.hospital.dto.EspecialidadDto;
import com.hospital.hospital.dto.PacienteDto;
import com.hospital.hospital.entity.Especialidad;
import com.hospital.hospital.entity.Paciente;
import com.hospital.hospital.exception.MessageNotFoundException;
import com.hospital.hospital.repository.EspecialidadRepository;
import com.hospital.hospital.repository.PacienteRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
    public ResponseEntity<List<PacienteDto>> findAll() {
        List<Paciente> pacientes = pacienteRepository.findAll();
        if (!pacientes.isEmpty()) {
            List<PacienteDto> pacienteDtos = pacientes.stream()
                    .map(paciente -> modelMapper.map(pacientes, PacienteDto.class))
                    .collect(Collectors.toList());
            return new ResponseEntity<>(pacienteDtos, HttpStatus.OK);
        }
        else {
            log.warn("Lista de pacientes esta vacia");
            throw new MessageNotFoundException("Lista de pacientes esta vacia");
        }
    }
}
