package com.udesc.socket.example.simple.example.database;

import com.udesc.socket.example.simple.example.model.Aluno;
import com.udesc.socket.example.simple.example.model.Professor;

import java.util.ArrayList;
import java.util.Objects;

public class ProfessorDB {

    private ArrayList<Professor> professores = new ArrayList<>();

    public boolean Create(Professor professor) {
        return professores.add(professor);
    }

    public boolean Delete(Professor professor) {
        return professores.remove(professor);
    }

    public boolean Update(Professor professor) {
        if (professores.removeIf(alu -> alu.getCpf().equals(professor.getCpf()))) {
            return professores.add(professor);
        }

        return false;
    }

    public String Get(String cpf) {
        return professores.stream()
                .filter(alu -> Objects.equals(alu.getCpf(), Integer.getInteger(cpf)))
                .findFirst()
                .toString();
    }

    public String[] list() {
        return (String[]) professores.stream().map(Object::toString).toList().toArray();
    }

}
