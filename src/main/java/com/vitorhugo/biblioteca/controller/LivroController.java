package com.vitorhugo.biblioteca.controller;

import com.vitorhugo.biblioteca.model.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/livros")
public class LivroController {

    private List<Livro> livros = new ArrayList<>();

    @GetMapping
    public String listar(Model model){
        model.addAttribute("livros", livros);
        return "livros";
    }

    @PostMapping
    public String cadastrar(@ModelAttribute Livro livro){
        livros.add(livro);
        return "redirect:/livros";
    }

    @PostMapping("/atualizar/{indice}")
    public String atualizar(@PathVariable int indice, @ModelAttribute Livro livro){

        if(indice >= 0 && indice < livros.size()){
            livros.set(indice, livro);
        }
        return "redirect:/livros";
    }

    @DeleteMapping("/excluir/{indice}")
    public String excluir(@PathVariable int indice){
        if(indice >= 0 && indice < livros.size()){
            livros.remove(indice);
        }
        return "redirect:/livros";
    }
}