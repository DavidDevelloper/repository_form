package com.projecto.formulario.login.services;

import com.projecto.formulario.login.models.domain.Role;

import java.util.List;

public interface RolService {
    List<Role>listar();
    Role obtenerPorId(Integer id);
}
