package com.seguridad.seguridadConJwt.repositories;

import com.seguridad.seguridadConJwt.models.ExamenEntity;
import com.seguridad.seguridadConJwt.models.PreguntaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface PreguntaRepository extends JpaRepository<PreguntaEntity, Long> {

    Set<PreguntaEntity> findByExamen(ExamenEntity examen);
}
