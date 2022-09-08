package com.udesc.socket.example.simple.example.database;

import com.udesc.socket.example.simple.example.model.Professor;
import com.udesc.socket.example.simple.example.model.Turma;

import java.util.ArrayList;
import java.util.Arrays;

public class TurmaDB {

    private ArrayList<Turma> turmas = new ArrayList<>();

    public boolean add(Turma turma) {
        return turmas.add(turma);
    }

    public boolean remove(Turma turma) {
        return turmas.remove(turma);
    }

    public String list() {
        return Arrays.toString(turmas.stream().map(Object::toString).toList().toArray());
    }

}
