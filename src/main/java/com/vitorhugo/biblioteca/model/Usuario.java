package com.vitorhugo.biblioteca.model;

import java.util.List;

public class Usuario {
    private String nome;
    private List<Emprestimo> emprestimos;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public void setEmprestimos(List<Emprestimo> emprestimos) {
        this.emprestimos = emprestimos;
    }
}
