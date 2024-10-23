package com.hospital.hospital.service;

import com.hospital.hospital.entity.Cita;
import com.hospital.hospital.exception.MessageConflictException;
import com.hospital.hospital.exception.MessageNotFoundException;
import com.hospital.hospital.repository.CitaRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Service(value = "citaService")
@Slf4j

public class CitaServiceImpl implements CitaService {

    private final CitaRepository citaRepository;

    private final ModelMapper modelMapper;

    public CitaServiceImpl(CitaRepository citaRepository, ModelMapper modelMapper) {
        this.citaRepository = citaRepository;
        this.modelMapper = modelMapper;

        // Configurar ModelMapper para evitar mapeos implícitos si es necesario
        this.modelMapper.getConfiguration().setSkipNullEnabled(true).setImplicitMappingEnabled(false);
    }

    @Override
    public ResponseEntity<List<Cita>> findAll() {
        List<Cita> codigoUS = citaRepository.findAll();
        if (!codigoUS.isEmpty()) {
            // Retornar la lista mapeada como respuesta con status OK
            return new ResponseEntity<>(codigoUS, HttpStatus.OK);
        } else {
            // Si no hay datos, lanzar excepción con un mensaje personalizado
            log.warn("No hay datos en la tabla paciente");
            throw new MessageNotFoundException("No hay datos en la tabla paciente");
        }
    }

    @Override
    public ResponseEntity<Cita> create(Cita cita) {
        if (!citaRepository.existsById(cita.getEstado_cita())) {
            citaRepository.save(cita);
            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(cita.getId())
                    .toUri();
            return ResponseEntity.created(location).body(cita);
        } else {
            throw new MessageConflictException("el consultorio ya existe");
        }
    }


}
