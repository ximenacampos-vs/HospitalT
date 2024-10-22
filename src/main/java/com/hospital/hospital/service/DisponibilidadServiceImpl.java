package com.hospital.hospital.service;

import com.hospital.hospital.entity.Disponibilidad;
import com.hospital.hospital.exception.MessageNotFoundException;
import com.hospital.hospital.repository.DisponibilidadRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service(value = "disponibilidadService")
@Slf4j

public class DisponibilidadServiceImpl implements DisponibilidadService{

    private final DisponibilidadRepository disponibilidadRepository;

    private final ModelMapper modelMapper;

    public DisponibilidadServiceImpl(DisponibilidadRepository disponibilidadRepository, ModelMapper modelMapper) {
        this.disponibilidadRepository = disponibilidadRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ResponseEntity<List<Disponibilidad>> findAll() {
        List<Disponibilidad> disponibilidads = disponibilidadRepository.findAll();
        if (!disponibilidads.isEmpty()) {
            return new ResponseEntity<>(disponibilidads, HttpStatus.OK);
        }
        else {
            log.warn("Lista de disponibilidad esta vacia");
            throw new MessageNotFoundException("Lista de disponibilidad esta vacia");
        }
    }
}
