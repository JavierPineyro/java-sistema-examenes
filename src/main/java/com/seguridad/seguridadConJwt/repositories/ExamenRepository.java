package com.seguridad.seguridadConJwt.repositories;

import com.seguridad.seguridadConJwt.models.ExamenEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamenRepository extends JpaRepository<ExamenEntity, Long> {
}
