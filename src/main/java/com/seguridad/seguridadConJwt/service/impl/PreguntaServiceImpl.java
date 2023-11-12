package com.seguridad.seguridadConJwt.service.impl;

import com.seguridad.seguridadConJwt.models.ExamenEntity;
import com.seguridad.seguridadConJwt.models.PreguntaEntity;
import com.seguridad.seguridadConJwt.repositories.PreguntaRepository;
import com.seguridad.seguridadConJwt.service.PreguntaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PreguntaServiceImpl implements PreguntaService {

    @Autowired
    private PreguntaRepository preguntaRepository;

    @Override
    public PreguntaEntity createPregunta(PreguntaEntity pregunta) {
        return preguntaRepository.save(pregunta);
    }

    @Override
    public PreguntaEntity updatePregunta(PreguntaEntity pregunta) {
        return preguntaRepository.save(pregunta);
    }

    @Override
    public Set<PreguntaEntity> getAllPreguntas() {
        return (Set<PreguntaEntity>) preguntaRepository.findAll();
    }

    @Override
    public PreguntaEntity getPregunta(Long id) {
        return preguntaRepository.findById(id).get();
    }

    @Override
    public Set<PreguntaEntity> getPreguntaFromExamen(ExamenEntity examen) {
        return preguntaRepository.findByExamen(examen);
    }

    @Override
    public void deletePregunta(Long id) {
        preguntaRepository.deleteById(id);

       /* PreguntaEntity pregunta = new PreguntaEntity();
        pregunta.setId(id);
        preguntaRepository.delete(pregunta);*/
    }

    @Override
    public PreguntaEntity listarPregunta(Long id) {
        return preguntaRepository.getOne(id);
    }
}
