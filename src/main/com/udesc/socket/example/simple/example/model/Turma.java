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

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public Integer getCreditos() {
        return creditos;
    }

    public void setCreditos(Integer creditos) {
        this.creditos = creditos;
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public boolean AddPessoa(Pessoa pessoa) {
        return this.pessoas.add(pessoa);
    }

    public boolean RemovePessoa(Pessoa pessoa) {
        return this.pessoas.remove(pessoa);
    }

    @Override
    public String toString() {
        return "Turma{" +
                "disciplina='" + disciplina + '\'' +
                ", creditos=" + creditos +
                ", pessoas=" + pessoas.stream().map(Object::toString).toList() +
                '}';
    }
}
