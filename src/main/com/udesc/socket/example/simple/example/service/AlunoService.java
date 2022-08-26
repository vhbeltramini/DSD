package com.udesc.socket.example.simple.example.service;

import com.udesc.socket.example.simple.example.database.AlunoDB;
import com.udesc.socket.example.simple.example.model.Aluno;

public class AlunoService extends PessoaService {

    private AlunoDB db;

    public AlunoService() {
        db = new AlunoDB();
    }

    @Override
    protected boolean Crete(String[] data) {
        db.Create((Aluno) formatPessoaData(ALUNO, data));
        return false;
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
    public String[] List() {
        return new String[0];
    }
}
