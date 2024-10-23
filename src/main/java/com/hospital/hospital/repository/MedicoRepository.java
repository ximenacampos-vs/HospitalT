package com.hospital.hospital.repository;

import com.hospital.hospital.entity.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@EnableJpaRepositories
public interface MedicoRepository extends JpaRepository<Medico, String> {


    @Transactional(readOnly = true)
    boolean existsByCodigo(String codigo);
}