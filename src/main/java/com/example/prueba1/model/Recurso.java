package com.example.prueba1.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Recurso {

    @Min(value = 1, message = "El Id debe ser un número positivo mayor a 0")
    @Max(value = 1000, message = "El Id debe no puede ser mayor a 1000")
    private int id;

    @NotBlank(message = "Debe ingresar un nombre")
    @Size(min = 3, max = 50, message = "El nombre debe tener entre 3 a 50 caracteres")
    private String nombre;

    @NotBlank(message = "Debe ingresar a un responsable del recurso")
    @Size(min = 3, max = 150, message = "El nombre del responsable debe ser entre 3 a 150 caracteres")
    private String responsable;

    @NotBlank(message = "Debe ingresar el tipo al que corresponde al recurso")
    @Size(min = 3, max = 50, message = "El recurso debe tener entre 3 a 50 caracteres")
    private String tipo;

    @Min(value = 1950, message = "El año de creación no puede ser menor a 1950")
    @Max(value = 2026, message = "El año de creacion no puede ser mayor a 2026")
    private int anioCreacion;
}
