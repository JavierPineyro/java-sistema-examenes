package com.seguridad.seguridadConJwt.service;

import com.seguridad.seguridadConJwt.models.CategoriaEntity;

import java.util.Set;

public interface CategoriaService {

    CategoriaEntity createCategoria(CategoriaEntity categoria);
    CategoriaEntity updateCategoria(CategoriaEntity categoria);
    Set<CategoriaEntity> getAllCategorias();
    CategoriaEntity getCategoria(Long id);
    void deleteCategoria(Long id);
}
