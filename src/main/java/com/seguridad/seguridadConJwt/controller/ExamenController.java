package com.seguridad.seguridadConJwt.controller;

import com.seguridad.seguridadConJwt.models.ExamenEntity;
import com.seguridad.seguridadConJwt.service.ExamenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/examen")
@CrossOrigin("*")
public class ExamenController {

    @Autowired
    private ExamenService examenService;

    @PostMapping("/")
    public ResponseEntity<ExamenEntity> guardarExamen(@RequestBody ExamenEntity examen) {
        return ResponseEntity.ok(examenService.createExamen(examen));
    }

    @PutMapping("/")
    public ResponseEntity<ExamenEntity> actualizarExamen(@RequestBody ExamenEntity examen) {
        return ResponseEntity.ok(examenService.updateExamen(examen));
    }

    @GetMapping("/")
    public ResponseEntity<?> listarExamenes(){
        return ResponseEntity.ok(examenService.getAllExamenes());
    }

    @GetMapping("/{id}")
    public ExamenEntity obtenerExamen(@PathVariable("id") Long id){
        return examenService.getExamen(id);
    }

    @DeleteMapping("/{id}")
    public void eliminarExamen(@PathVariable("id") Long id){
        examenService.deleteExamen(id);
    }
}