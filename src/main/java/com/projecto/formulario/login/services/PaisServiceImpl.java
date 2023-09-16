package com.projecto.formulario.login.services;

import com.projecto.formulario.login.models.domain.Pais;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PaisServiceImpl implements PaisService{
    private List<Pais> lista;

    public PaisServiceImpl(){
        this.lista= Arrays.asList(
                new Pais(1,"ES","Espana"),
                new Pais(1,"MX","Mexico"),
                new Pais(1,"CL","Chile"),
                new Pais(1,"AR","Argentina"),
                new Pais(1,"ES","Espana"),
                new Pais(1,"ES","Espana"),
                new Pais(1,"ES","Espana"),
                new Pais(1,"ES","Espana"));

    }

    @Override
    public List<Pais> listar() {
        return lista;
    }

    @Override
    public Pais obtenerPorId(Integer id) {
        Pais resultado =null;
        for(Pais pais:this.lista){
            if(id == pais.getId()){
                resultado = pais;
                break;
            }
        }
        return resultado;
    }
}
