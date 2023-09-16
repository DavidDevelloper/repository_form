package com.projecto.formulario.login.editors;

import com.projecto.formulario.login.services.RolService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.beans.PropertyEditorSupport;
@Component
public class RolesEditor extends PropertyEditorSupport {
    @Autowired
    private RolService service;

    @Override
    public void setAsText(String text) throws IllegalArgumentException{
        try{
            Integer id = Integer.parseInt(text);
            setValue(service.obtenerPorId(id));
        }catch (NumberFormatException e){
            setValue(null);
        }
    }
}
