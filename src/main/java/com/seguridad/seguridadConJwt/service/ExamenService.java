package com.seguridad.seguridadConJwt.service;

import com.seguridad.seguridadConJwt.models.CategoriaEntity;
import com.seguridad.seguridadConJwt.models.ExamenEntity;

import java.util.List;
import java.util.Set;

public interface ExamenService {

    ExamenEntity createExamen(ExamenEntity examen);
    ExamenEntity updateExamen(ExamenEntity examen);
    Set<ExamenEntity> getAllExamenes();
    ExamenEntity getExamen(Long id);
    void deleteExamen(Long id);

    List<ExamenEntity> getExamenesFromCategoria(CategoriaEntity categoria);

}
