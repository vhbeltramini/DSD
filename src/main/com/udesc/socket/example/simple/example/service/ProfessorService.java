package com.udesc.socket.example.simple.example.service;

import com.udesc.socket.example.simple.example.database.AlunoDB;
import com.udesc.socket.example.simple.example.database.ProfessorDB;
import com.udesc.socket.example.simple.example.model.Aluno;
import com.udesc.socket.example.simple.example.model.Professor;

public class ProfessorService extends PessoaService {

    private ProfessorDB db;

    public ProfessorService() {
        db = ProfessorDB.getInstance();
    }

    @Override
    protected boolean Create(String[] data) {
        return db.Create((Professor) formatPessoaData(PROFESSOR, data));
    }

    @Override
    protected String Get(String[] data) {
        return db.Get(data[2]).toString();
    }

    @Override
    protected boolean Delete(String[] data) {
        return db.Delete(Integer.parseInt(data[2]));
    }

    @Override
    protected boolean Update(String[] data) {
        return db.Update((Professor) formatPessoaData(PROFESSOR, data));
    }

    @Override
    public String List() {
        return db.List();
    }
}
