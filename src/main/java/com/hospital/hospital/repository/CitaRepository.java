package com.hospital.hospital.repository;

import com.hospital.hospital.entity.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@EnableJpaRepositories
public interface CitaRepository extends JpaRepository<Cita, String> {

    @Transactional(readOnly = true)
    boolean existsById(String Cita);
}