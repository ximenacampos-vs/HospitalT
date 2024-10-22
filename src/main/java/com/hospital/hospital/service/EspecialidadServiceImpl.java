package com.hospital.hospital.service;

import com.hospital.hospital.entity.Especialidad;
import com.hospital.hospital.exception.MessageConflictException;
import com.hospital.hospital.exception.MessageNotFoundException;
import com.hospital.hospital.repository.EspecialidadRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@Service(value = "especialidadService")
@Slf4j

public class EspecialidadServiceImpl implements EspecialidadService{

    private final EspecialidadRepository especialidadRepository;

    private final ModelMapper modelMapper;

    public EspecialidadServiceImpl(EspecialidadRepository especialidadRepository, ModelMapper modelMapper) {
        this.especialidadRepository = especialidadRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ResponseEntity<List<Especialidad>> findAll() {
        List<Especialidad> especialidades = especialidadRepository.findAll();
        if (!especialidades.isEmpty()) {
            return new ResponseEntity<>(especialidades, HttpStatus.OK);
        }
        else {
            log.warn("Lista de especialidades esta vacia");
            throw new MessageNotFoundException("Lista de especialidades esta vacia");
        }
    }

    @Override
    public ResponseEntity<Especialidad> create(Especialidad especialidad) {
        especialidad.setNombre(especialidad.getNombre().toUpperCase());
        if (!especialidadRepository.existsByNombre(especialidad.getNombre())){
            especialidad.setNombre(especialidad.getNombre().toUpperCase());
            especialidadRepository.save(especialidad);
            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(especialidad.getId())
                    .toUri();
            return ResponseEntity.created(location).body(especialidad);
        } else {
            throw new MessageConflictException("La especialidad ya existe");
        }
    }
}
