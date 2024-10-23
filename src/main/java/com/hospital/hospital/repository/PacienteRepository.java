package com.hospital.hospital.repository;

import com.hospital.hospital.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@EnableJpaRepositories
public interface PacienteRepository extends JpaRepository<Paciente, String> {

    @Transactional(readOnly = true)
    boolean existsById(String Paciente);

}
