package com.hospital.hospital.service;

import com.hospital.hospital.dto.ConsultorioDto;
import com.hospital.hospital.entity.Consultorio;
import com.hospital.hospital.exception.MessageNotFoundException;
import com.hospital.hospital.repository.ConsultorioRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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
   public ResponseEntity<List<ConsultorioDto>> findAll() {
        List<Consultorio> consultorios = consultorioRepository.findAll();
        if (!consultorios.isEmpty()) {
            List<ConsultorioDto> consultorioDtos = consultorios.stream()
                    .map(consultorio -> modelMapper.map(consultorio, ConsultorioDto.class))
                    .collect(Collectors.toList());
            return new ResponseEntity<>(consultorioDtos, HttpStatus.OK);
        }
        else {
            log.warn("Lista de consultorios esta vacia");
            throw new MessageNotFoundException("Lista de consultorios esta vacia");
        }
    }
}
