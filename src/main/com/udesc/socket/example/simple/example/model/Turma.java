package com.udesc.socket.example.simple.example.model;

import java.util.ArrayList;
import java.util.List;

public class Turma {

    private String disciplina;
    private Integer creditos;

    private List<Pessoa> pessoas = new ArrayList<>();

    public Turma(String disciplina, Integer creditos) {
        this.disciplina = disciplina;
        this.creditos = creditos;
    }

    public void AddPessoa(Pessoa pessoa) {
        this.pessoas.add(pessoa);
    }

    public void RemovePessoa(Pessoa pessoa) {
        this.pessoas.remove(pessoa);
    }

}
