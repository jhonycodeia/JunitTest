package org.appmockito.ejemplos.services;

import java.util.Optional;

import org.appmockito.ejemplos.models.Examen;

public interface ExamenService {
    Optional<Examen> findExamenPorNombre(String nombre);

    Examen findExamenPorNombreConPreguntas(String nombre);

    Examen guardar(Examen examen);
}
