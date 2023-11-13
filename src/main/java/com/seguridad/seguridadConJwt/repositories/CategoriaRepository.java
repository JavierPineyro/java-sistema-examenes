package com.seguridad.seguridadConJwt.repositories;

import com.seguridad.seguridadConJwt.models.CategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoriaRepository extends JpaRepository<CategoriaEntity, Long> {

    List<CategoriaEntity> findByTituloContainingIgnoreCase(String query);

}
