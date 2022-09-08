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

    public String List() {
        return professores.stream().map(Object::toString)
                .collect(Collectors.joining(", "));
    }

    public Professor getProfessor(String cpf){
        return professores.stream()
                .filter(prof -> Objects.equals(prof.getCpf(), Integer.parseInt(cpf)))
                .findAny().get();
    }


    public static ProfessorDB getInstance() {
        if (professorDB == null) {
            professorDB = new ProfessorDB();
            return professorDB;
        }
        return professorDB;
    }

}
