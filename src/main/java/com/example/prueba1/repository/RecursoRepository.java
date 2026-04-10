package com.example.prueba1.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.prueba1.model.Recurso;

@Repository
public class RecursoRepository {

    public List<Recurso> listaRecursos = new ArrayList<>();

    public List<Recurso> obtenerRecursos() {
        return listaRecursos;
    }

    public Recurso buscarxId(int id) {
        for (Recurso recurso : listaRecursos) {
            if (recurso.getId() == id) {
                return recurso;
            }
        }
        return null;
    }

    public Recurso buscarxNombre(String nombre) {
        for (Recurso recurso : listaRecursos) {
            if (recurso.getNombre().equals(nombre)) {
                return recurso;
            }
        }
        return null;
    }

    public Recurso guardar(Recurso rec) {
        if (buscarxId(rec.getId()) != null) {
            return null;
        }
        listaRecursos.add(rec);
        return rec;
    }

    public Recurso actualizar(Recurso rec) {
        for (int i = 0; i < listaRecursos.size(); i++) {
            if (listaRecursos.get(i).getId() == rec.getId()) {
                listaRecursos.set(i, rec);
                return rec;
            }
        }
        return null;
    }

    public boolean eliminar(int id) {
        Recurso recurso = buscarxId(id);
        if (recurso != null) {
            listaRecursos.remove(recurso);
            return true;
        }
        return false;
    }

}
