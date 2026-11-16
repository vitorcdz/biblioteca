package com.vitorhugo.biblioteca.controller;

import com.vitorhugo.biblioteca.model.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/livros")
public class LivroController {

    private List<Livro> livros = new ArrayList<>();

    @PostMapping
    public String cadastrar(@ModelAttribute Livro livro){
        livros.add(livro);
        return "redirect:/livros";
    }

    @GetMapping("/inicio")
    public String inicio(Model model) {
        return "livros/inicio";
    }
}
