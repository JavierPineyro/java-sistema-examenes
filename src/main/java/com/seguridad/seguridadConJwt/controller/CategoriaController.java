package com.seguridad.seguridadConJwt.controller;

import com.seguridad.seguridadConJwt.models.CategoriaEntity;
import com.seguridad.seguridadConJwt.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/categoria")
@CrossOrigin("*")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @PostMapping("/")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<CategoriaEntity> guardarCategoria(@RequestBody CategoriaEntity categoria){
        CategoriaEntity savedCategoria = categoriaService.createCategoria(categoria);
        return ResponseEntity.ok(savedCategoria);
    }

    @GetMapping("/{id}")
    public CategoriaEntity obtenerCategoria(@PathVariable("id") Long id){
        return categoriaService.getCategoria(id);
    }

    @GetMapping("/")
    public ResponseEntity<?> listarCategorias(){
        return ResponseEntity.ok(categoriaService.getAllCategorias());
    }

    @PutMapping("/")
    @PreAuthorize("hasRole('ADMIN')")
    public CategoriaEntity actualizarCategoria(@RequestBody CategoriaEntity categoria){
        return categoriaService.updateCategoria(categoria);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void eliminarCategoria(@PathVariable("id") Long id){
        categoriaService.deleteCategoria(id);
    }
}
