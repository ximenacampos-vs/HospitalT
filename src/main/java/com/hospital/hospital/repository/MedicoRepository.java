package com.hospital.hospital.repository;

import com.hospital.hospital.entity.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico, String> {
}