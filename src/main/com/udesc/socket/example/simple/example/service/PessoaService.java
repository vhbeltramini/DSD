package com.udesc.socket.example.simple.example.service;

import com.udesc.socket.example.simple.example.model.Aluno;
import com.udesc.socket.example.simple.example.model.Pessoa;
import com.udesc.socket.example.simple.example.model.Professor;

public abstract class PessoaService {

    public static final String PROFESSOR = "PROFESSOR";
    public static final String ALUNO = "ALUNO";

    protected abstract boolean Create(String[] data);

    protected abstract String Get(String[] data);

    protected abstract boolean Delete(String[] data);

    protected abstract boolean Update(String[] data);

    public abstract String List();

    protected Pessoa formatPessoaData(int pessoaType, String[] data) {
        if (pessoaType == 0) {
            return new Aluno(Integer.parseInt(data[2]), data[3], data[4], Integer.parseInt(data[5]));
        }
        return new Professor(Integer.parseInt(data[2]), data[3], data[4], data[5]);
    }



}
