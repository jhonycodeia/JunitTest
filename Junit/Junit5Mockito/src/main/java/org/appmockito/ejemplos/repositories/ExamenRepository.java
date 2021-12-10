package org.appmockito.ejemplos.repositories;

import java.util.List;

import org.appmockito.ejemplos.models.Examen;

public interface ExamenRepository {
    Examen guardar(Examen examen);
    List<Examen> findAll();
}
