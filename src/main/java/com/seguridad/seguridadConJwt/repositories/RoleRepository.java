package com.seguridad.seguridadConJwt.repositories;

import com.seguridad.seguridadConJwt.models.RoleEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<RoleEntity, Long> {
}
