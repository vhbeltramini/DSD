package com.udesc.socket.example.simple.example.database;

import com.udesc.socket.example.simple.example.model.Professor;

import java.util.ArrayList;
import java.util.Objects;

public class ProfessorDB {

    private static ProfessorDB professorDB;
    private ArrayList<Professor> professores = new ArrayList<>();

    private ProfessorDB() {}

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
                .filter(alu -> Objects.equals(alu.getCpf(), Integer.parseInt(cpf)))
                .findFirst()
                .toString();
    }

    public String List() {
        return professores.stream().map(Object::toString).toList().toString();
    }


    public static ProfessorDB getInstance() {
        if (professorDB == null) {
            professorDB = new ProfessorDB();
            return professorDB;
        }
        return professorDB;
    }

}
