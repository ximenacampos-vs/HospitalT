package com.hospital.hospital.repository;

import com.hospital.hospital.entity.Consultorio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@EnableJpaRepositories
public interface ConsultorioRepository extends JpaRepository<Consultorio, String> {

    @Transactional(readOnly = true)
    boolean existsByConsultorio(String consultorio);
}