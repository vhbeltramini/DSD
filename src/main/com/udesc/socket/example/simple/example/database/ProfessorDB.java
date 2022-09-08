package com.udesc.socket.example.simple.example.database;

import com.udesc.socket.example.simple.example.model.Professor;

import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Collectors;

public class ProfessorDB {

    private static ProfessorDB professorDB;
    private ArrayList<Professor> professores;

    private ProfessorDB() {
        professores = new ArrayList<>();
    }

    public boolean Create(Professor professor) {
        if (professores.stream().anyMatch(p -> p.getCpf().equals(professor.getCpf()))) {
            return false;
        }
        return professores.add(professor);
    }

    public boolean Delete(int cpf) {
        return professores.removeIf(professor -> professor.getCpf().equals(cpf));
    }

    public boolean Update(Professor professor) {
        if (professores.removeIf(prof -> prof.getCpf().equals(professor.getCpf()))) {
            return professores.add(professor);
        }
        return false;
    }

    public String Get(String cpf) {
        return professores.stream()
                .filter(alu -> Objects.equals(alu.getCpf(), Integer.parseInt(cpf)))
                .findFirst()
                .toString();
    }

    public Professor GetProfessor(String cpf) {
        if (professores.stream().anyMatch(professor -> professor.getCpf().equals(Integer.parseInt(cpf)))) {
            return professores.stream()
                    .filter(professor -> Objects.equals(professor.getCpf(), Integer.parseInt(cpf)))
                    .findAny().get();
        }
        return null;
    }

    public String List() {
        return professores.stream().map(Object::toString)
                .collect(Collectors.joining(", "));
    }

    public static ProfessorDB getInstance() {
        if (professorDB == null) {
            professorDB = new ProfessorDB();
            return professorDB;
        }
        return professorDB;
    }

}
