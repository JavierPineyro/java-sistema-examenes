package com.seguridad.seguridadConJwt.repositories;

import com.seguridad.seguridadConJwt.models.CategoriaEntity;
import com.seguridad.seguridadConJwt.models.ExamenEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExamenRepository extends JpaRepository<ExamenEntity, Long> {

    List<ExamenEntity> findByCategoria(CategoriaEntity categoria);

    List<ExamenEntity> findByActivo(Boolean estado);

    List<ExamenEntity> findByCategoriaAndActivo(CategoriaEntity categoria, Boolean estado);

    List<ExamenEntity> findByTituloContainingIgnoreCase(String query);

    List<ExamenEntity> findByCategoriaAndTituloContainingIgnoreCase(CategoriaEntity categoria, String query);
}
