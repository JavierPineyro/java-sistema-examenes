package com.seguridad.seguridadConJwt.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "preguntas")
public class PreguntaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 5000)
    private String contenido;

    private String opcion1;
    private String opcion2;
    private String opcion3;
    private String opcion4;
    private String respuesta;

    @ManyToOne(fetch = FetchType.EAGER)
    private ExamenEntity examen;

}
