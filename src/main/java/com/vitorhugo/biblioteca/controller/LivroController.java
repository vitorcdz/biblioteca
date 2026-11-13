package com.vitorhugo.biblioteca.controller;

import com.vitorhugo.biblioteca.model.Autor;
import com.vitorhugo.biblioteca.model.Livro;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/biblioteca")
public class LivroController {
    @GetMapping("/livros")
    public String exibirLivros(Model model){
        Livro livro = new Livro();
        livro.setTitulo("Dom Casmurro");
        livro.setAutor("Machado de Assis");
        livro.setIsbn("987-85-00-00000-0");
        livro.setCategoria("Romance");
        livro.setDisponibilidade("Disponível");

        model.addAttribute("livro",livro);
        return "livro";
    }

    @GetMapping("/autores")
    public String exibirAutores(Model model){
        Autor autor = new Autor();
        autor.setNome("Machado de Assis");
        autor.setNacionalidade("Brasileiro");
        autor.setLivros(List.of("Dom Casmurro","Quincas Borba"));
        model.addAttribute("autor",autor);
        return "autor";
    }

}
