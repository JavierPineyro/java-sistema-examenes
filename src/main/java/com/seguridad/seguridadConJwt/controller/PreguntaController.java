package com.seguridad.seguridadConJwt.controller;

import com.seguridad.seguridadConJwt.models.ExamenEntity;
import com.seguridad.seguridadConJwt.models.PreguntaEntity;
import com.seguridad.seguridadConJwt.service.ExamenService;
import com.seguridad.seguridadConJwt.service.PreguntaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

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

    @PostMapping("/evaluar-examen")
    public ResponseEntity<?> evaluarExamen(@RequestBody List<PreguntaEntity> preguntas){
        double puntosMaximos = 0;
        Integer respuestasCorrectas = 0;
        Integer intentos = 0;

        for (PreguntaEntity pregunta : preguntas){
            PreguntaEntity question = preguntaService.listarPregunta(pregunta.getId());

            if(question.getRespuesta().equals(pregunta.getRespuestaDada())){
                respuestasCorrectas++;
                double puntos = Double.parseDouble(preguntas.get(0).getExamen().getPuntosMaximos())/ preguntas.size();
                puntosMaximos += puntos;
            }

            if(pregunta.getRespuestaDada() != null){
                intentos++;
            }
        }

        Map<String, Object> respuestas = new HashMap<>();
        respuestas.put("puntosMaximos", puntosMaximos);
        respuestas.put("respuestasCorrectas", respuestasCorrectas);
        respuestas.put("intentos", intentos);

        return ResponseEntity.ok(respuestas);
    }

}
