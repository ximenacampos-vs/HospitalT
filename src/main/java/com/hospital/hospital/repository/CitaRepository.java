package com.hospital.hospital.repository;

import com.hospital.hospital.entity.Cita;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CitaRepository extends JpaRepository<Cita, String> {
}