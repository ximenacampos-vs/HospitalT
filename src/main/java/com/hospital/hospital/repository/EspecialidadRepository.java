package com.hospital.hospital.repository;

import com.hospital.hospital.entity.Especialidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@EnableJpaRepositories
public interface EspecialidadRepository extends JpaRepository<Especialidad, String> {

    @Transactional(readOnly = true)
    boolean existsByNombre(String nombre);
}