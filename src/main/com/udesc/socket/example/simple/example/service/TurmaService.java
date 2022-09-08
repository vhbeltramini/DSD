package com.udesc.socket.example.simple.example.service;

import com.udesc.socket.example.simple.example.database.AlunoDB;
import com.udesc.socket.example.simple.example.database.ProfessorDB;
import com.udesc.socket.example.simple.example.database.TurmaDB;
import com.udesc.socket.example.simple.example.model.Pessoa;
import com.udesc.socket.example.simple.example.model.Turma;

public class TurmaService {

    public static final String TURMA = "TURMA";
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

    protected boolean Delete(String[] data){
        return db.Delete(data[2]);
    }


    protected String Get(String[] data){
        return db.Get(data[2]);
    }

    protected boolean AddPessoaTurma(String[] data){
        Pessoa pessoa = getPessoa(data);
        if (pessoa == null) return false;
        return db.AddPessoaTurma(data[2], pessoa);
    }

    protected boolean RemovePessoaTurma(String[] data){
        Pessoa pessoa = getPessoa(data);
        if (pessoa == null) return false;

        return db.RemovePessoaTurma(data[2], pessoa);
    }

    private Pessoa getPessoa(String[] data) {
        Pessoa pessoa;
        if (alunoDB.getAluno(data[3]) != null) {
            pessoa = alunoDB.getAluno(data[3]);
        } else if (professorDB.GetProfessor(data[3]) != null){
            pessoa = professorDB.GetProfessor(data[3]);
        } else {
            return null;
        }
        return pessoa;
    }


    protected String List(){
        return db.List();
    }

    protected Turma formatTurmaData(String[] data){
        return new Turma(data[2], Integer.parseInt(data[3]));
    }

}
