package com.seguridad.seguridadConJwt.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRolesController {

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String accessAdmin(){
        return "Hola, accediste como admin";
    }


    @GetMapping("/usuario")
    @PreAuthorize("hasRole('USER')")
    public String accessUser(){
        return "Hola, accediste como usuario";
    }


    @GetMapping("/obtener-todos")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public String accessCualquiera(){
        return "Hola, accediste a un endpoint publico, te doy todos los resultados";
    }
}
