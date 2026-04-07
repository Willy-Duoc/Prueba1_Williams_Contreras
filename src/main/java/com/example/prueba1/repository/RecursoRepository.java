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
            return recurso;
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
        listaRecursos.add(rec);
        return rec;
    }

    public Recurso actualizar(Recurso rec) {
        int id = 0;
        int idPosicion = 0;
        for (int i = 0; i < listaRecursos.size(); i++) {
            if (listaRecursos.get(i).getId() == rec.getId()) {
                id = rec.getId();
                idPosicion = i;
            }
        }
        Recurso rec1 = new Recurso();
        rec1.setId(id);
        rec1.setNombre(rec.getNombre());
        rec1.setResponsable(rec.getResponsable());
        rec1.setTipo(rec.getTipo());
        rec1.setAnioCreacion(rec.getAnioCreacion());
        listaRecursos.set(idPosicion, rec1);
        return rec1;
    }

    public void eliminar(int id) {
        Recurso recurso = buscarxId(id);
        if (recurso != null) {
            listaRecursos.remove(recurso);
        }
    }

}
