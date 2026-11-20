package com.vitorhugo.biblioteca.controller;

import com.vitorhugo.biblioteca.model.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/emprestimos")
public class EmprestimoController {

    private List<Emprestimo> emprestimos = new ArrayList<>();

    @GetMapping
    public String listar(Model model){
        model.addAttribute("emprestimos", emprestimos);
        return "emprestimos";
    }

    @PostMapping
    public String cadastrar(@ModelAttribute Emprestimo emprestimo){
        emprestimos.add(emprestimo);
        return "redirect:/emprestimos";
    }

    @PostMapping("/atualizar/{indice}")
    public String atualizar(@PathVariable int indice, @ModelAttribute Emprestimo emprestimo){
        if(indice >= 0 && indice < emprestimos.size()){
            emprestimos.set(indice, emprestimo);
        }

        return "redirect:/emprestimos";
    }

    @DeleteMapping("/excluir/{indice}")
    public String excluir(@PathVariable int indice){
        if(indice >= 0 && indice < emprestimos.size()){
            emprestimos.remove(indice);
        }

        return "redirect:/emprestimos";
    }
}