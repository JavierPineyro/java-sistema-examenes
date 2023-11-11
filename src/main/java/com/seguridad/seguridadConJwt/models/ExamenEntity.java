package com.seguridad.seguridadConJwt.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "examenes")
public class ExamenEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String titulo;
    private String descripcion;

    private String puntosMaximos;
    private String numeroDePreguntas;
    private boolean activo = false;

    @ManyToOne(fetch = FetchType.EAGER)
    private CategoriaEntity categoria;

    @OneToMany(mappedBy = "examen", fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<PreguntaEntity> preguntas = new HashSet<>();
}
