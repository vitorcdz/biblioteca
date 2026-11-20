package com.vitorhugo.biblioteca.controller;

import com.vitorhugo.biblioteca.model.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/autores")
public class AutorController {

    private List<Autor> autores = new ArrayList<>();

    @GetMapping
    public String listar(Model model){
        model.addAttribute("autores", autores);
        return "autores";
    }

    @PostMapping
    public String cadastrar(@ModelAttribute Autor autor){
        autores.add(autor);
        return "redirect:/autores";
    }

    @PostMapping("/atualizar/{indice}")
    public String atualizar(@PathVariable int indice, @ModelAttribute Autor autor){
        if(indice >= 0 && indice < autores.size()){
            autores.set(indice, autor);
        }
        return "redirect:/autores";
    }

    @DeleteMapping("/excluir/{indice}")
    public String excluir(@PathVariable int indice){
        if(indice >= 0 && indice < autores.size()){
            autores.remove(indice);
        }
        return "redirect:/autores";
    }
}