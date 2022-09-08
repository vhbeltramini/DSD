package com.udesc.socket.example.simple.example.database;

import com.udesc.socket.example.simple.example.model.Aluno;
import com.udesc.socket.example.simple.example.model.Turma;

import java.util.ArrayList;
import java.util.Arrays;

public class TurmaDB {

    private ArrayList<Turma> turmas;
    private static TurmaDB turmaDB;

    private TurmaDB(){
        turmas = new ArrayList<>();
    }

    public boolean Create(Turma turma) {
        return turmas.add(turma);
    }

    public String list() {
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
