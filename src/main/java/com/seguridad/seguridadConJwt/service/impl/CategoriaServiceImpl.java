package com.seguridad.seguridadConJwt.service.impl;

import com.seguridad.seguridadConJwt.models.CategoriaEntity;
import com.seguridad.seguridadConJwt.repositories.CategoriaRepository;
import com.seguridad.seguridadConJwt.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public CategoriaEntity createCategoria(CategoriaEntity categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public CategoriaEntity updateCategoria(CategoriaEntity categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public Set<CategoriaEntity> getAllCategorias() {
        return new LinkedHashSet<>(categoriaRepository.findAll());
    }

    @Override
    public CategoriaEntity getCategoria(Long id) {
        return categoriaRepository.findById(id).get();
    }

    @Override
    public void deleteCategoria(Long id) {
        categoriaRepository.deleteById(id);
       /*
        CategoriaEntity categoria = new CategoriaEntity();
        categoria.setId(id);
        categoriaRepository.delete(categoria);*/
    }
}
