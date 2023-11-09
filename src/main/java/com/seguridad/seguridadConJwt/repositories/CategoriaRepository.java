package com.seguridad.seguridadConJwt.repositories;

import com.seguridad.seguridadConJwt.models.CategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<CategoriaEntity, Long> {

}
