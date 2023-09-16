package com.projecto.formulario.login.services;

import com.projecto.formulario.login.models.domain.Pais;

import java.util.List;

public interface PaisService {
    List<Pais> listar();
    Pais  obtenerPorId(Integer id);

}
