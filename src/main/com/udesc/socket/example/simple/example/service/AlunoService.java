package com.udesc.socket.example.simple.example.service;

import com.udesc.socket.example.simple.example.database.AlunoDB;
import com.udesc.socket.example.simple.example.model.Aluno;

public class AlunoService extends PessoaService {

    private AlunoDB db;

    public AlunoService() {
        db = AlunoDB.getInstance();
    }

    @Override
    protected boolean Crete(String[] data) {
        return db.Create((Aluno) formatPessoaData(ALUNO, data));
    }

    @Override
    protected String Get(String[] data) {
        return db.Get(data[2]);
    }

    @Override
    protected boolean Delete(String[] data) {
        return db.Remove(Integer.parseInt(data[2]));
    }

    @Override
    protected boolean Update(String[] data) {
        return db.Update((Aluno) formatPessoaData(ALUNO, data));
    }

    @Override
    protected boolean Remove(String[] data) {
        return db.Remove(Integer.parseInt(data[2]));
    }

    @Override
    public String List() {
        return db.list();
    }
}
