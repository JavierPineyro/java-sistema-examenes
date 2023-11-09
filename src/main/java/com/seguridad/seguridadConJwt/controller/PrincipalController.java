package com.seguridad.seguridadConJwt.controller;

import com.seguridad.seguridadConJwt.controller.request.CreateUserDTO;
import com.seguridad.seguridadConJwt.models.ERole;
import com.seguridad.seguridadConJwt.models.RoleEntity;
import com.seguridad.seguridadConJwt.models.UserEntity;
import com.seguridad.seguridadConJwt.repositories.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
public class PrincipalController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepo;

    @GetMapping("/hello")
    public String hello(){
        return "hello not sucured yet";
    }

    @GetMapping("/helloSecured")
    public String helloSecured(){
        return "Hello secured!!!";
    }

    @PostMapping("/createUser")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> createUser(@Valid @RequestBody CreateUserDTO createUserDTO){
        Set<RoleEntity> roles = createUserDTO.getRoles().stream()
                .map(role -> RoleEntity.builder()
                        .name(ERole.valueOf(role))
                        .build())
                .collect(Collectors.toSet());

        UserEntity userEntity = UserEntity.builder()
                .username(createUserDTO.getUsername())
                .password(passwordEncoder.encode(createUserDTO.getPassword()))
                .email(createUserDTO.getEmail())
                .roles(roles)
                .build();

        userRepo.save(userEntity);
        return ResponseEntity.ok(userEntity);
    }

    @DeleteMapping("/deleteUser")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteUser(@RequestParam String id){
        userRepo.deleteById(Long.parseLong(id));
        return "Se ha borrado el usuario con id: ".concat(id);
    }
}
