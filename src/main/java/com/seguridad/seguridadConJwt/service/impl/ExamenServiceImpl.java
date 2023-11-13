package com.seguridad.seguridadConJwt.service.impl;

import com.seguridad.seguridadConJwt.models.CategoriaEntity;
import com.seguridad.seguridadConJwt.models.ExamenEntity;
import com.seguridad.seguridadConJwt.repositories.ExamenRepository;
import com.seguridad.seguridadConJwt.service.ExamenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Service
public class ExamenServiceImpl implements ExamenService {

    @Autowired
    private ExamenRepository examenRepository;

    @Override
    public ExamenEntity createExamen(ExamenEntity examen) {
        return examenRepository.save(examen);
    }

    @Override
    public ExamenEntity updateExamen(ExamenEntity examen) {
        return examenRepository.save(examen);
    }

    @Override
    public Set<ExamenEntity> getAllExamenes() {
        return new LinkedHashSet<>(examenRepository.findAll());
    }

    @Override
    public ExamenEntity getExamen(Long id) {
        return examenRepository.findById(id).get();
    }

    @Override
    public void deleteExamen(Long id) {
        // examenRepository.deleteById(id);

        // en caso de que no funcione lo de arriba
        ExamenEntity examen = new ExamenEntity();
        examen.setId(id);
        examenRepository.delete(examen);
    }

    @Override
    public List<ExamenEntity> getExamenesFromCategoria(CategoriaEntity categoria) {
        return examenRepository.findByCategoria(categoria);
    }

    @Override
    public List<ExamenEntity> getExamenesByActivo() {
        return examenRepository.findByActivo(true);
    }

    @Override
    public List<ExamenEntity> getExamenesByActivoFromCategoria(CategoriaEntity categoria) {
        return examenRepository.findByCategoriaAndActivo(categoria, true);
    }

    @Override
    public List<ExamenEntity> getExamenesByTitulo(String titulo) {
        return examenRepository.findByTituloContainingIgnoreCase(titulo);
    }

    @Override
    public List<ExamenEntity> getExamenesFromCategoriaAndTituloContainingQuery(CategoriaEntity categoria, String query) {
        return examenRepository.findByCategoriaAndTituloContainingIgnoreCase(categoria, query);
    }


}
