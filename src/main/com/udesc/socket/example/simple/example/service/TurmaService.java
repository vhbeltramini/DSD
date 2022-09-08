package com.udesc.socket.example.simple.example.service;

import com.udesc.socket.example.simple.example.database.AlunoDB;
import com.udesc.socket.example.simple.example.database.ProfessorDB;
import com.udesc.socket.example.simple.example.database.TurmaDB;
import com.udesc.socket.example.simple.example.model.Pessoa;
import com.udesc.socket.example.simple.example.model.Turma;

public class TurmaService {

    private TurmaDB db;
    private ProfessorDB professorDB;
    private AlunoDB alunoDB;

    public TurmaService() {
        db = TurmaDB.getInstance();
        alunoDB = AlunoDB.getInstance();
        professorDB = ProfessorDB.getInstance();
    }

    protected boolean Create(String[] data){
        return db.Create(formatTurmaData(data));
    }

    protected String List(){
        return db.list();
    }

    protected Turma formatTurmaData(String[] data){
        return new Turma(data[1], Integer.parseInt(data[2]));
    }

    protected boolean addPessoa(String cpf){
        Pessoa pessoa = alunoDB.getAluno(cpf);
        if(pessoa == null){
            pessoa = professorDB.getProfessor(cpf);
        }
        return pessoa != null;
    }
}
