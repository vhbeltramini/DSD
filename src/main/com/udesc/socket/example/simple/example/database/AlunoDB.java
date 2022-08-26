package com.udesc.socket.example.simple.example.database;

import com.udesc.socket.example.simple.example.model.Aluno;

import java.util.ArrayList;
import java.util.Objects;

public class AlunoDB {

    private ArrayList<Aluno> alunos = new ArrayList<>();

    public boolean Create(Aluno aluno) {
        return alunos.add(aluno);
    }

    public boolean Delete(Aluno aluno) {
        return alunos.remove(aluno);
    }

    public boolean Update(Aluno aluno) {
        if (alunos.removeIf(alu -> alu.getCpf().equals(aluno.getCpf()))) {
            return alunos.add(aluno);
        }

        return false;
    }

    public String Get(String cpf) {
        return alunos.stream()
                .filter(alu -> Objects.equals(alu.getCpf(), Integer.getInteger(cpf)))
                .findFirst()
                .toString();
    }

    public String[] list() {
        return (String[]) alunos.stream().map(Object::toString).toList().toArray();
    }

}
