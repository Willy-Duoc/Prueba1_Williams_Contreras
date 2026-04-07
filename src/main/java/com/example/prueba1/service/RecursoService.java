package com.example.prueba1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.prueba1.model.Recurso;
import com.example.prueba1.repository.RecursoRepository;

@Service
public class RecursoService {
    @Autowired
    private RecursoRepository recursoRepository;

    public List<Recurso> getRecursos() {
        return recursoRepository.obtenerRecursos();
    }

    public Recurso saveRecurso(Recurso recurso) {
        return recursoRepository.guardar(recurso);
    }

    public Recurso getRecursoId(int id) {
        return recursoRepository.buscarxId(id);
    }

    public Recurso updateRecurso(Recurso recurso) {
        return recursoRepository.actualizar(recurso);
    }

    public String deleteRecurso(int id) {
        recursoRepository.eliminar(id);
        return "Recurso eliminado del registro";
    }
}
