package com.vitorhugo.biblioteca.controller;

import com.vitorhugo.biblioteca.model.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class LivroController {

    @GetMapping("/biblioteca")
    public String inicio(Model model) {

        //Cria a categoria
        Categoria romance = new Categoria();
        romance.setCategoria("Romance");

        Categoria aventura = new Categoria();
        aventura.setCategoria("Aventura");

        //Cria o autor
        Autor autor1 = new Autor();
        autor1.setNome("Machado de Assis");
        autor1.setNacionalidade("Brasileiro");

        Autor autor2 = new Autor();
        autor2.setNome("J. R. R. Tolkien");
        autor2.setNacionalidade("Britânico");

        //Cria os livros
        Livro livro1 = new Livro();
        livro1.setTitulo("Dom Casmurro");
        livro1.setAutor(autor1);
        livro1.setIsbn("987-85-00-00000-0");
        livro1.setCategoria(romance);
        livro1.setDisponibilidade("Disponível");

        Livro livro2 = new Livro();
        livro2.setTitulo("O Senhor dos Anéis");
        livro2.setAutor(autor2);
        livro2.setIsbn("987-85-11-11111-1");
        livro2.setCategoria(aventura);
        livro2.setDisponibilidade("Emprestado");

        //Relacionando os autores com seus livros
        autor1.setLivros(List.of(livro1));
        autor2.setLivros(List.of(livro2));

        //Cria os usuários
        Usuario usuario1 = new Usuario();
        usuario1.setNome("João Silva");

        Usuario usuario2 = new Usuario();
        usuario2.setNome("Maria Souza");

        //Cria os empréstimos
        Emprestimo emprestimo1 = new Emprestimo();
        emprestimo1.setAluno(usuario1);
        emprestimo1.setLivro(livro2);
        emprestimo1.setRetirada(LocalDateTime.now());
        emprestimo1.setDevolucao(LocalDateTime.now().plusDays(7));

        usuario1.setEmprestimos(List.of(emprestimo1));
        usuario2.setEmprestimos(List.of());

        model.addAttribute("livros", List.of(livro1, livro2));
        model.addAttribute("autores", List.of(autor1, autor2));
        model.addAttribute("categorias", List.of(romance, aventura));
        model.addAttribute("usuarios", List.of(usuario1, usuario2));
        model.addAttribute("emprestimos", List.of(emprestimo1));

        return "livros/inicio";
    }
}
