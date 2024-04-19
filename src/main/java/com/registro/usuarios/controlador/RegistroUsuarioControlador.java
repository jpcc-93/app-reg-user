package com.registro.usuarios.controlador;

import com.registro.usuarios.dto.UsuarioRegistroDTO;
import com.registro.usuarios.service.UsuarioServicio;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registro")
public class RegistroUsuarioControlador {

    private UsuarioServicio usuarioServicio;

    public RegistroUsuarioControlador(UsuarioServicio usuarioServicio) {
        this.usuarioServicio = usuarioServicio;
    }

    @ModelAttribute("usuario")
    public UsuarioRegistroDTO retornoUsuarioRegistroDTO(){
        return new UsuarioRegistroDTO();
    }

    @GetMapping
    public String mostrarFormularioRegistro(){
        return "registro";
    }

    @PostMapping
    public String RegistrarCuentaUsuario(@ModelAttribute("usuario") UsuarioRegistroDTO usuarioRegistroDTO){
        usuarioServicio.guardar(usuarioRegistroDTO);
        return "redirect:/registro?exito";}
}
