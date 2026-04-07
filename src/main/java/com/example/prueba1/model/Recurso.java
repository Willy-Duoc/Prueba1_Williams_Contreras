package com.example.prueba1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Recurso {
    private int id;
    private String nombre;
    private String responsable;
    private String tipo;
    private int anioCreacion;
}
