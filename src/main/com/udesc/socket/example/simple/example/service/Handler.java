package com.udesc.socket.example.simple.example.service;

public class Handler {

    private PessoaService pessoaService;

    public Handler(int type) {
        switch (type) {
            case PessoaService.ALUNO:
                pessoaService = new AlunoService();
                break;
            case PessoaService.PROFESSOR:
                pessoaService = new ProfessorService();
                break;
            default:

        }
    }

    public String AddPessoa(String[] data) {
        System.out.println("data 1 " + data[1]);

        if (pessoaService.Create(data)) {
            return "Pessoa criada";
        }
        return "Error";
    }

    public String GetPessoa(String[] data) {
        try {
            return pessoaService.Get(data);
        }catch (Exception e){
            return "Pessoa nao encontrada";
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

}
