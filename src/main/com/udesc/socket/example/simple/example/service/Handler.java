package com.udesc.socket.example.simple.example.service;

public class Handler {

    private PessoaService pessoaService;
    private TurmaService turmaService;

    public Handler(String type) {
        switch (type) {
            case PessoaService.ALUNO:
                pessoaService = new AlunoService();
                break;
            case PessoaService.PROFESSOR:
                pessoaService = new ProfessorService();
                break;
            case TurmaService.TURMA:
                turmaService = new TurmaService();
                break;
            default:

        }
    }

    public String AddPessoa(String[] data) {
        System.out.println("data 1 " + data[1]);

        if (pessoaService.Create(data)) {
            return "Pessoa criada";
        }
        return "Erro ou pessoa já existente";
    }

    public String GetPessoa(String[] data) {
        try {
            return pessoaService.Get(data);
        }catch (Exception e){
            return "Pessoa não encontrada";
        }
    }

    public String UpdatePessoa(String[] data) {
        if (pessoaService.Update(data)) {
            return "Pessoa atualizada";
        }
        return "Pessoa nao encontrada";
    }

    public String DeletePessoa(String[] data) {
        if (pessoaService.Delete(data)) {
            return "Pessoa removida";
        }
        return "Pessoa nao encontrada";
    }

    public String ListPessoas() {
        return pessoaService.List();
    }


    public String ListTurma() {
        return turmaService.List();
    }

    public String CreateTurma(String[] data) {
        if (turmaService.Create(data)) {
            return "Turma criada";
        }
        return "Erro ou turma já existente";
    }

    public String DeleteTurma(String[] data) {
        if (turmaService.Delete(data)) {
            return "Turma removida";
        }
        return "Error";
    }

    public String GetTurma(String[] data) {
        return turmaService.Get(data);
    }

    public String AddPessoaTurma(String[] data) {
        if (turmaService.AddPessoaTurma(data)) {
            return "Pessoa adicionada a turma";
        }
        return "Error";
    }

    public String RemovePessoaTurma(String[] data) {
        if (turmaService.RemovePessoaTurma(data)) {
            return "Pessoa removida da turma";
        }
        return "Error";
    }


}
