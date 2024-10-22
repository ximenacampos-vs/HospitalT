package com.hospital.hospital.repository;

import com.hospital.hospital.entity.Especialidad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EspecialidadRepository extends JpaRepository<Especialidad, String> {
}