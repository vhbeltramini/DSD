package com.udesc.socket.example.simple.example.database;

import com.udesc.socket.example.simple.example.model.Aluno;

import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Collectors;

public class AlunoDB {

    private static AlunoDB alunoDB;
    private ArrayList<Aluno> alunos;

    public boolean Create(Aluno aluno) {
        if (alunos.stream().anyMatch(a -> a.getCpf().equals(aluno.getCpf()))) {
            return false;
        }
        return alunos.add(aluno);
    }

    public boolean Remove(Integer cpf) {
        return alunos.removeIf(aluno -> aluno.getCpf().equals(cpf));
    }

    public boolean Update(Aluno aluno) {
        if (alunos.removeIf(alu -> alu.getCpf().equals(aluno.getCpf()))) {
            return alunos.add(aluno);
        }

        return false;
    }

    public String Get(String cpf) {
        return alunos.stream()
                .filter(alu -> Objects.equals(alu.getCpf(), Integer.parseInt(cpf)))
                .findFirst()
                .toString();
    }

    public String list() {
        return alunos.stream().map(Object::toString)
                .collect(Collectors.joining(", "));
    }

    public Aluno getAluno(String cpf){
        if (alunos.stream().anyMatch(aluno -> aluno.getCpf().equals(Integer.parseInt(cpf)))) {
            return alunos.stream()
                    .filter(alu -> Objects.equals(alu.getCpf(), Integer.parseInt(cpf)))
                    .findAny().get();
        }
        return null;
    }

    private AlunoDB() {
        alunos = new ArrayList<>();
    }

    public static AlunoDB getInstance() {
        if (alunoDB == null) {
            alunoDB = new AlunoDB();
            return alunoDB;
        }
        return alunoDB;
    }

}
