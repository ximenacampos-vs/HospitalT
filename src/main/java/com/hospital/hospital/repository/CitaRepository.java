package com.hospital.hospital.repository;

import com.hospital.hospital.entity.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface CitaRepository extends JpaRepository<Cita, String> {
}