package com.udesc.socket.example.simple.example.database;

import com.udesc.socket.example.simple.example.model.Pessoa;
import com.udesc.socket.example.simple.example.model.Turma;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class TurmaDB {

    private ArrayList<Turma> turmas = new ArrayList<>();
    private static TurmaDB turmaDB;

    private TurmaDB(){
    }

    public boolean Create(Turma turma) {
        if (turmas.stream().anyMatch(t -> t.getDisciplina().equals(turma.getDisciplina()))) {
            return false;
        }
        return turmas.add(turma);
    }
    public Turma GetTurma(String disciplina) {
        return turmas.stream().filter(t -> t.getDisciplina().equals(disciplina)).findFirst().get();
    }

    public String Get(String disciplina) {
        return turmas.stream().filter(t -> t.getDisciplina().equals(disciplina)).findFirst().get().toString();
    }

    public boolean Delete(String disciplina) {
        return turmas.removeIf(t -> t.getDisciplina().equals(disciplina));
    }

    public boolean AddPessoaTurma(String disciplina, Pessoa pessoa) {
        return turmas.stream().filter(t -> Objects.equals(t.getDisciplina(), disciplina)).findFirst().get().AddPessoa(pessoa);
    }
    public boolean RemovePessoaTurma(String disciplina, Pessoa pessoa) {
        return turmas.stream().filter(t -> Objects.equals(t.getDisciplina(), disciplina)).findFirst().get().RemovePessoa(pessoa);
    }

    public String List() {
        return Arrays.toString(turmas.stream().map(Object::toString).toArray());
    }

    public static TurmaDB getInstance() {
        if (turmaDB == null) {
            turmaDB = new TurmaDB();
            return turmaDB;
        }
        return turmaDB;
    }
}
