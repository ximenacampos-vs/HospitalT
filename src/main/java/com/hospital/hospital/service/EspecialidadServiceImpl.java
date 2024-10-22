package com.hospital.hospital.service;

import com.hospital.hospital.dto.EspecialidadDto;
import com.hospital.hospital.entity.Especialidad;
import com.hospital.hospital.exception.MessageNotFoundException;
import com.hospital.hospital.repository.EspecialidadRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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
    public ResponseEntity<List<EspecialidadDto>> findAll() {
        List<Especialidad> especialidades = especialidadRepository.findAll();
        if (!especialidades.isEmpty()) {
            List<EspecialidadDto> especialidadDtos = especialidades.stream()
                    .map(especialidad -> modelMapper.map(especialidad, EspecialidadDto.class))
                    .collect(Collectors.toList());
            return new ResponseEntity<>(especialidadDtos, HttpStatus.OK);
        }
        else {
            log.warn("Lista de especialidades esta vacia");
            throw new MessageNotFoundException("Lista de especialidades esta vacia");
        }
    }
}
