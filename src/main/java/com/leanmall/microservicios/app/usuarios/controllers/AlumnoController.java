package com.leanmall.microservicios.app.usuarios.controllers;

import com.leanmall.microservicios.app.usuarios.models.dto.AlumnosDTO;
import com.leanmall.microservicios.app.usuarios.models.entity.Alumnos;
import com.leanmall.microservicios.app.usuarios.services.IAlumnosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

@RestController
@RequestMapping("/api/alumnos")
public class AlumnoController {

    @Autowired
    private final IAlumnosServices alumnosServices;

    public AlumnoController(IAlumnosServices alumnosServices) {
        this.alumnosServices = alumnosServices;
    }

    @GetMapping
    public ResponseEntity<?> listar(){
        return ResponseEntity.ok().body(alumnosServices.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtener(@PathVariable Long id){
        AlumnosDTO alumnosDTO = alumnosServices.findById(id);
        if (alumnosDTO == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(alumnosDTO);
    }

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody AlumnosDTO alumnosDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(alumnosServices.create(alumnosDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@PathVariable Long id, @RequestBody AlumnosDTO alumnosDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(alumnosServices.update(id, alumnosDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        alumnosServices.deleted(id);
        return ResponseEntity.noContent().build();
    }

}
