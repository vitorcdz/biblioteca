package com.vitorhugo.biblioteca.controller;

import com.vitorhugo.biblioteca.model.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    private List<Usuario> usuarios = new ArrayList<>();

    @GetMapping
    public String listar(Model model){
        model.addAttribute("usuarios", usuarios);
        return "usuarios";
    }

    @PostMapping
    public String cadastrar(@ModelAttribute Usuario usuario){
        usuarios.add(usuario);
        return "redirect:/usuarios";
    }

    @PostMapping("/atualizar/{indice}")
    public String atualizar(@PathVariable int indice, @ModelAttribute Usuario usuario){

        if(indice >= 0 && indice < usuarios.size()){
            usuarios.set(indice, usuario);
        }
        return "redirect:/usuarios";
    }

    @DeleteMapping("/excluir/{indice}")
    public String excluir(@PathVariable int indice){
        if(indice >= 0 && indice < usuarios.size()){
            usuarios.remove(indice);
        }

        return "redirect:/usuarios";
    }
}