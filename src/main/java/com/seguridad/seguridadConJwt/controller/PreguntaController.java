package com.seguridad.seguridadConJwt.controller;

import com.seguridad.seguridadConJwt.models.ExamenEntity;
import com.seguridad.seguridadConJwt.models.PreguntaEntity;
import com.seguridad.seguridadConJwt.service.ExamenService;
import com.seguridad.seguridadConJwt.service.PreguntaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/pregunta")
@CrossOrigin("*")
public class PreguntaController {

    @Autowired
    private PreguntaService preguntaService;

    @Autowired
    private ExamenService examenService;

    @PostMapping("/")
    public ResponseEntity<PreguntaEntity> guardarPregunta(@RequestBody PreguntaEntity pregunta){
        return ResponseEntity.ok(preguntaService.createPregunta(pregunta));
    }

    @PutMapping("/")
    public ResponseEntity<PreguntaEntity> actualizarPregunta(@RequestBody PreguntaEntity pregunta){
        return ResponseEntity.ok(preguntaService.updatePregunta(pregunta));
    }

    @GetMapping("/examen/{id}")
    public ResponseEntity<?> listarPreguntasDeUnExamen(@PathVariable("id") Long id){
        ExamenEntity examen = examenService.getExamen(id);
        // Set<PreguntaEntity> preguntas = examen.getPreguntas();
        Set<PreguntaEntity> preguntas = preguntaService.getPreguntaFromExamen(examen);

        List examenes = new ArrayList<>(preguntas);
        if(examenes.size() > Integer.parseInt(examen.getNumeroDePreguntas())){
            examenes = examenes.subList(0, Integer.parseInt(examen.getNumeroDePreguntas()+1));
        }

        Collections.shuffle(examenes);
        return ResponseEntity.ok(examenes);
    }

    @GetMapping("/{id}")
    public PreguntaEntity obtenerPregunta(@PathVariable("id") Long id){
        return preguntaService.getPregunta(id);
    }

    @DeleteMapping("/{id}")
    public void eliminarPregunta(@PathVariable("id") Long id){
        preguntaService.deletePregunta(id);
    }

}
