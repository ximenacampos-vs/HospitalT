package com.hospital.hospital.service;

import com.hospital.hospital.entity.Medico;
import com.hospital.hospital.exception.MessageNotFoundException;
import com.hospital.hospital.repository.MedicoRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service(value = "medicoService")
@Slf4j

public class MedicoServiceImpl implements MedicoService {

    private final ModelMapper modelMapper;
    private final MedicoRepository medicoRepository;

    public MedicoServiceImpl(MedicoRepository medicoRepository, ModelMapper modelMapper) {
        this.medicoRepository = medicoRepository;
        this.modelMapper = modelMapper;

    }

    @Override
    public ResponseEntity<List<Medico>> findAll() {
        List<Medico> medicos = medicoRepository.findAll();
        if (!medicos.isEmpty()) {
            return new ResponseEntity<>(medicos, HttpStatus.OK);
        }
        else {
            log.warn("Lista de medicos esta vacia");
            throw new MessageNotFoundException("Lista de medicos esta vacia");
        }
    }
}
