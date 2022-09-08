package com.udesc.socket.example.simple.example.service;

import com.udesc.socket.example.simple.example.database.AlunoDB;
import com.udesc.socket.example.simple.example.database.ProfessorDB;
import com.udesc.socket.example.simple.example.model.Professor;

public class ProfessorService extends PessoaService {

    private ProfessorDB db;

    public ProfessorService() {
        db = ProfessorDB.getInstance();
    }

    @Override
    protected boolean Crete(String[] data) {
        return db.Create((Professor) formatPessoaData(PROFESSOR, data));
    }

    @Override
    protected String Get(String[] data) {
        return db.Get(data[2]);
    }

    @Override
    protected boolean Delete(String[] data) {
        return false;
    }

    @Override
    protected boolean Update(String[] data) {
        return false;
    }

    @Override
    protected boolean Remove(String[] data) {
        return false;
    }

    @Override
    public String List() {
        return db.List();
    }
}
