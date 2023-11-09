package com.seguridad.seguridadConJwt.service;

import com.seguridad.seguridadConJwt.models.ExamenEntity;
import com.seguridad.seguridadConJwt.models.PreguntaEntity;

import java.util.Set;

public interface PreguntaService {

    PreguntaEntity createPregunta(PreguntaEntity pregunta);
    PreguntaEntity updatePregunta(PreguntaEntity pregunta);
    Set<PreguntaEntity> getAllPreguntas();
    PreguntaEntity getPregunta(Long id);
    Set<PreguntaEntity> getPreguntaFromExamen(ExamenEntity examen);
    void deletePregunta(Long id);
}
