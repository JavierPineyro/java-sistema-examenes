package com.seguridad.seguridadConJwt.controller;

import com.seguridad.seguridadConJwt.models.CategoriaEntity;
import com.seguridad.seguridadConJwt.models.ExamenEntity;
import com.seguridad.seguridadConJwt.service.ExamenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/categoria/{id}")
    public List<ExamenEntity> listarExamenesPorCategoria(@PathVariable("id") Long id){
        CategoriaEntity categoria = new CategoriaEntity();
        categoria.setId(id);
        return examenService.getExamenesFromCategoria(categoria);
    }

    @GetMapping("/activo")
    public List<ExamenEntity> listarExamenesActivos(){
        return examenService.getExamenesByActivo();
    }

    @GetMapping("/categoria/activo/{id}")
    public List<ExamenEntity> listarExamenesActivosDeUnaCategoria(@PathVariable("id") Long id){
        CategoriaEntity categoria = new CategoriaEntity();
        categoria.setId(id);
        return examenService.getExamenesByActivoFromCategoria(categoria);
    }

    @GetMapping("/titulo")
    public List<ExamenEntity> listarExamenesPorTitutlo(@RequestParam(required = false) String query){
        return examenService.getExamenesByTitulo(query);
    }

    @GetMapping("/categoria/{id}/titulo")
    public List<ExamenEntity> listarExamenesDeCategoriaPorTitulo(@PathVariable("id") Long id, @RequestParam(required = false) String query){
        CategoriaEntity categoria = new CategoriaEntity();
        categoria.setId(id);
        return examenService.getExamenesFromCategoriaAndTituloContainingQuery(categoria, query);
    }
}