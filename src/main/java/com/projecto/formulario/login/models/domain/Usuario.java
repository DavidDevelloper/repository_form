package com.projecto.formulario.login.models.domain;
import com.projecto.formulario.login.validation.IdentificadorRegex;
import com.projecto.formulario.login.validation.Requerido;
import jakarta.validation.constraints.*;

import java.util.Date;
import java.util.List;

public class Usuario {

    @IdentificadorRegex
    private String identificador;
    @Requerido
    private String nombre;
    @Requerido
    private String apellido;
    @NotBlank
    @Size(min = 3,max = 8 )
    private String username;
    @NotEmpty
    private String password;
    @Requerido
    @Email(message = "correocon formato incorrecto ")
    private String email;

    @NotNull
    @Min(5)
    @Max(5000)
    private Integer cuenta;

    @NotNull
    @Past
    private Date fechaNacimiento;
    @NotNull
    private Pais pais;
    @NotEmpty
    private List<Role> roles;

    private Boolean habilitar;

    @NotEmpty
    private String Genero;

    private String valorSecreto;

    public String getIdentificador() {
        return identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getCuenta() {
        return cuenta;
    }

    public void setCuenta(Integer cuenta) {
        this.cuenta = cuenta;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Boolean getHabilitar() {
        return habilitar;
    }

    public void setHabilitar(Boolean habilitar) {
        this.habilitar = habilitar;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String genero) {
        Genero = genero;
    }

    public String getValorSecreto() {
        return valorSecreto;
    }

    public void setValorSecreto(String valorSecreto) {
        this.valorSecreto = valorSecreto;
    }
}
