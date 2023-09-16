package com.projecto.formulario.login.controllers;

import com.projecto.formulario.login.editors.NombreMayusculaEditor;
import com.projecto.formulario.login.editors.PaisPropertyEditor;
import com.projecto.formulario.login.editors.RolesEditor;
import com.projecto.formulario.login.models.domain.Pais;
import com.projecto.formulario.login.models.domain.Role;
import com.projecto.formulario.login.models.domain.Usuario;
import com.projecto.formulario.login.services.PaisService;
import com.projecto.formulario.login.services.RolService;
import com.projecto.formulario.login.validation.UsuarioValidador;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@SessionAttributes("usuario")
public class ForController {
    @Autowired
    private UsuarioValidador validador;
    @Autowired
    private PaisService paisService;
    @Autowired
    private RolService rolService;
    @Autowired
    private PaisPropertyEditor paisEditor;
    @Autowired
    private RolesEditor rolesEditor;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(validador);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, "nombre", new NombreMayusculaEditor());
        binder.registerCustomEditor(String.class, "apellido", new NombreMayusculaEditor());

        binder.registerCustomEditor(Pais.class, "pais", paisEditor);
        binder.registerCustomEditor(Role.class, "roles", rolesEditor);
    }

    @ModelAttribute("genero")
    public List<String> genero() {
        return Arrays.asList("Hombre", "Mujer");
    }

    @ModelAttribute("listaRoles")
    public List<Role> listaRoles() {
        return this.rolService.listar();
    }

    @ModelAttribute("listaPaises")
    public List<Pais> listaPaises() {
        return paisService.listar()
    }

    @ModelAttribute("ListaRolesString")
    public List<String> listaRolesString() {
        List<String> roles = new ArrayList<>();
        roles.add("ROLES_ADMIN");
        roles.add("ROLE_USER");
        roles.add("ROLE_MODERATOR");
        return roles;
    }

    @ModelAttribute("listaRolesMap")
    public Map<String, String> listaRolesMap() {
        Map<String, String> roles = new HashMap<>();
        roles.put("ROLE_ADMIN", "Administrador");
        roles.put("ROLE_USER", "Usuario");
        roles.put("ROLE_MODERATOR", "Moderator");

        return roles;
    }

    @ModelAttribute("paises")
    public List<String> paises() {
        return Arrays.asList("Espana", "Mexico", "Chile", "Argentina", "Peru", "Colombia", "Venezuela");
    }

    @ModelAttribute("pisesMap")
    public Map<String, String> paisesMap (){
        Map<String,String> paises = new HashMap<>();
        paises.put("ES","Espana");
        paises.put("ES","Espana");
        paises.put("ES","Espana");
        paises.put("ES","Espana");
        paises.put("ES","Espana");
        paises.put("ES","Espana");
        paises.put("ES","Espana");
        paises.put("ES","Espana");

        return paises;
    }
    @GetMapping("/form")
    public String form (Model model){
        Usuario usuario= new Usuario();
        usuario.setNombre("john");
        usuario.setApellido("Doe");
        usuario.setIdentificador("123.456.789-k");
        usuario.setHabilitar(true);
        usuario.setValorSecreto("algun valor secreto ****");
        usuario.setPais(new Pais(1,"CL","Chile"));
        usuario.setRoles(Arrays.asList(new Role(2,"Usuario","ROLE_USER")));


    }

    @PostMapping("/form")
    public String procesar(@Valid Usuario usuario, BindingResult result,Model model){
        if(result.hasErrors()){
            model.addAttribute("titulo","Resultado form");
            return "form";
        }
        return "redirect:/ver";
    }
    @GetMapping("/ver")
    public String ver(@SessionAttribute(name = "usuario",required = false)Usuario usuario, Model model,
                      SessionStatus)
}