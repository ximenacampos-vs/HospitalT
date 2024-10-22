package com.hospital.hospital.service;

import com.hospital.hospital.dto.ConsultorioDto;
import com.hospital.hospital.dto.EnfermerasDto;
import com.hospital.hospital.entity.Consultorio;
import com.hospital.hospital.entity.Enfermeras;
import com.hospital.hospital.exception.MessageNotFoundException;
import com.hospital.hospital.repository.ConsultorioRepository;
import com.hospital.hospital.repository.EnfermerasRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
    public ResponseEntity<List<EnfermerasDto>> findAll() {
        List<Enfermeras> enfermera = enfermerasRepository.findAll();
        if (!enfermera.isEmpty()) {
            List<EnfermerasDto> enfermerasDtos = enfermera.stream()
                    .map(enfermeras -> modelMapper.map(enfermeras, EnfermerasDto.class))
                    .collect(Collectors.toList());
            return new ResponseEntity<>(enfermerasDtos, HttpStatus.OK);
        }
        else {
            log.warn("Lista de enfermeras esta vacia");
            throw new MessageNotFoundException("Lista de enfermeras esta vacia");
        }
    }
}
