package com.hospital.hospital.repository;

import com.hospital.hospital.entity.Consultorio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultorioRepository extends JpaRepository<Consultorio, String> {
}