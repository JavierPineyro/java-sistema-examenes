package com.seguridad.seguridadConJwt.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedHashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "categorias")
public class CategoriaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String descripcion;

    @OneToMany(mappedBy = "categoria",orphanRemoval = true, cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<ExamenEntity> examenes = new LinkedHashSet<>();
}
