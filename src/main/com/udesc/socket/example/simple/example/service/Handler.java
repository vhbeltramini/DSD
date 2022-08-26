package com.udesc.socket.example.simple.example.service;

import com.udesc.socket.example.simple.example.model.Professor;

public class Handler {

    private PessoaService pessoaService;

    public Handler(int type) {
        switch (type) {
            case PessoaService.ALUNO:
                pessoaService = new AlunoService();
            case PessoaService.PROFESSOR:
                pessoaService = new ProfessorService();
            default:
        }
    }

    public boolean addPessoa(String[] data) {
        System.out.println("data 1 " + data[1]);

        return pessoaService.Crete(data);
    }

    public String getPessoa(String[] data) {
        return pessoaService.Get(data);
    }

}
