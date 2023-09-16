package com.projecto.formulario.login.services;

import com.projecto.formulario.login.models.domain.Role;

import java.util.ArrayList;
import java.util.List;

public class RoleServiceImpl implements RolService{
    private List<Role> roles;
    public RoleServiceImpl(){
        this.roles = new ArrayList<>();
        this.roles.add(new Role(1,"Administrador","ROLE_ADMIN"));
        this.roles.add(new Role(1,"Usuario","ROLE_USER"));
        this.roles.add(new Role(1,"Moderador","ROLE_MODELADOR"));
    }

    @Override
    public List<Role> listar() {
        return roles;
    }

    @Override
    public Role obtenerPorId(Integer id) {
        Role resultado = null;
        for(Role role: roles){
            if(id == role.getId()){
                resultado = role;
                break;
            }
        }
        return resultado;
    }
}
