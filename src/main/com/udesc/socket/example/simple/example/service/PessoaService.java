package com.udesc.socket.example.simple.example.service;

import com.udesc.socket.example.simple.example.model.Aluno;
import com.udesc.socket.example.simple.example.model.Pessoa;
import com.udesc.socket.example.simple.example.model.Professor;

public abstract class PessoaService {

    public static final int PROFESSOR = 1;
    public static final int ALUNO = 0;

    protected abstract boolean Crete(String[] data);

    protected abstract String Get(String[] data);

    protected abstract boolean Delete(String[] data);

    protected abstract boolean Update(String[] data);

    protected abstract boolean Remove(String[] data);

    public abstract String List();

    protected Pessoa formatPessoaData(int pessoaType, String[] data) {
        if (pessoaType == 0) {
            return new Aluno(Integer.parseInt(data[2]), data[3], data[4], Integer.parseInt(data[5]));
        }
        return new Professor(Integer.parseInt(data[2]), data[3], data[4]);
    }



}
