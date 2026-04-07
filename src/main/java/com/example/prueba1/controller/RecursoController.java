package com.example.prueba1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.prueba1.model.Recurso;
import com.example.prueba1.service.RecursoService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1/recursos")
public class RecursoController {
    @Autowired
    private RecursoService recursoService;

    @GetMapping
    public List<Recurso> listarRecursos() {
        return recursoService.getRecursos();
    }

    @PostMapping
    public Recurso agregaRecurso(@RequestBody Recurso recurso) {
        return recursoService.saveRecurso(recurso);
    }

    @GetMapping("{id}")
    public Recurso buscaRecurso(@PathVariable int id) {
        return recursoService.getRecursoId(id);
    }

    @DeleteMapping("{id}")
    public String eliminarRecurso(@PathVariable int id) {
        return recursoService.deleteRecurso(id);
    }
}
