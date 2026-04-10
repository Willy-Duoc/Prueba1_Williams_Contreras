package com.example.prueba1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.prueba1.model.Recurso;
import com.example.prueba1.service.RecursoService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1/recursos")

public class RecursoController {
    @Autowired
    private RecursoService recursoService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getRecurso(@PathVariable int id) {
        Recurso recurso = recursoService.getRecursoId(id);
        if (recurso == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Recurso no encontrado");
        }
        return ResponseEntity.ok(recurso);
    }

    @PostMapping
    public ResponseEntity<?> crearRecurso(@Valid @RequestBody Recurso recurso) {
        Recurso nuevo = recursoService.saveRecurso(recurso);
        if (nuevo == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Ya existe un recurso con ese ID");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }

    @GetMapping("{id}")
    public Recurso buscaRecurso(@PathVariable int id) {
        return recursoService.getRecursoId(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarRecurso(@PathVariable int id) {
        boolean eliminado = recursoService.deleteRecurso(id);
        if (!eliminado) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Recurso no encontrado");
        }
        return ResponseEntity.ok("Recurso eliminado correctamente");
    }

    @PutMapping
    public ResponseEntity<?> actualizarRecurso(@Valid @RequestBody Recurso recurso) {
        Recurso actualizado = recursoService.updateRecurso(recurso);
        if (actualizado == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Recurso no encontrado");
        }
        return ResponseEntity.ok(actualizado);
    }

}
